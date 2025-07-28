package com.sylvester.bank.service;

import com.sylvester.bank.dto.*;

public interface UserService {
    BankResponse createAccount(UserRequest userRequest);
    BankResponse balanceEnquiry(EnquiryRequest enquiryRequest);
    String nameEnquiry(EnquiryRequest enquiryRequest);
    BankResponse creditAccount(CreditAndDebitRequest creditAndDebitRequest);
    BankResponse debitAccount(CreditAndDebitRequest creditAndDebitRequest);
    BankResponse transfer(TransferRequest transferRequest);
    BankResponse login(LoginDto loginDto);
}
