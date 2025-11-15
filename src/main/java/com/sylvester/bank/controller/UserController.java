package com.sylvester.bank.controller;

import com.sylvester.bank.config.JwtTokenProvider;
import com.sylvester.bank.dto.*;
import com.sylvester.bank.entity.Token;
import com.sylvester.bank.repository.TokenRepository;
import com.sylvester.bank.service.EmailService;
import com.sylvester.bank.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final EmailService emailService;
    private final TokenRepository tokenRepository;
    @Autowired
    private UserService userService;
    @PostMapping("/public/create")
    public ResponseEntity<BankResponse> createAccount(@RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(userService.createAccount(userRequest), HttpStatus.CREATED);
    }
    @GetMapping("/balance")
    public ResponseEntity<BankResponse> balanceEnquiry(@RequestBody EnquiryRequest enquiryRequest) {
        return new ResponseEntity<>(userService.balanceEnquiry(enquiryRequest), HttpStatus.OK);
    }
    @GetMapping("/name")
    public ResponseEntity<String> nameEnquiry(@RequestBody EnquiryRequest enquiryRequest) {
        return new ResponseEntity<>(userService.nameEnquiry(enquiryRequest), HttpStatus.OK);
    }

    @PostMapping("/credit")
    public ResponseEntity<BankResponse> creditEnquiry(@RequestBody CreditAndDebitRequest creditAndDebitRequest) {
        return new ResponseEntity<>(userService.creditAccount(creditAndDebitRequest), HttpStatus.CREATED);
    }

    @PostMapping("/debit")
    public ResponseEntity<BankResponse> debitAccount(@RequestBody CreditAndDebitRequest creditAndDebitRequest) {
        return new ResponseEntity<>(userService.debitAccount(creditAndDebitRequest), HttpStatus.OK);
    }

    @PostMapping("/transfer")
    public ResponseEntity<BankResponse> transferAccount(@RequestBody TransferRequest transferRequest) {
        return new ResponseEntity<>(userService.transfer(transferRequest), HttpStatus.OK);
    }



    @PostMapping("/public/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                 new  UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String token = jwtTokenProvider.generateToken(userDetails);

            Token jwtToken = new Token();
            jwtToken.setToken(token);
            jwtToken.setUser(userService.getUserByEmail(userDetails.getUsername()));
            jwtToken.setRevoked(false);
            jwtToken.setExpired(false);
            tokenRepository.save(jwtToken);



            return ResponseEntity.ok().body(Map.of("JwtToken", token));
        } catch (AuthenticationException e) {
            Map<String, String> map = new HashMap<>();
            map.put("message", "Invalid username or password");
            return new ResponseEntity<>(map, HttpStatus.UNAUTHORIZED);
        }


    }


}
