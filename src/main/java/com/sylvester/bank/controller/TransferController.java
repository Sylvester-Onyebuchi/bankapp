package com.sylvester.bank.controller;

import com.itextpdf.text.DocumentException;
import com.sylvester.bank.entity.Transaction;
import com.sylvester.bank.service.BankStatement;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/bankStatement")
@AllArgsConstructor
public class TransferController {
    @Autowired
    private BankStatement bankStatement;
    @GetMapping
    public ResponseEntity<List<Transaction>> getBankStatement(@RequestParam String accountNumber,
                                                             @RequestParam String startDate,
                                                             @RequestParam String endDate) throws DocumentException, FileNotFoundException {
        return new ResponseEntity<>(bankStatement.generateStatement(accountNumber, startDate, endDate), HttpStatus.OK);
    }
}
