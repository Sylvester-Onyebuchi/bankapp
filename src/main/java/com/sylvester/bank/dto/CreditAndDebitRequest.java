package com.sylvester.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreditAndDebitRequest {
    private String accountNumber;
    private BigDecimal amount;
}
