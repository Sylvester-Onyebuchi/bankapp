package com.sylvester.bank.controller;

import com.sylvester.bank.dto.*;
import com.sylvester.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/create")
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

    @PostMapping("/login")
    public ResponseEntity<BankResponse> login(@RequestBody LoginDto loginDto) {
        return new ResponseEntity<>(userService.login(loginDto), HttpStatus.OK);
    }
}
