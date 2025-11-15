package com.sylvester.bank.service;

import com.sylvester.bank.dto.*;
import com.sylvester.bank.entity.User;

public interface UserService {
    BankResponse createAccount(UserRequest userRequest);
    BankResponse balanceEnquiry(EnquiryRequest enquiryRequest);
    String nameEnquiry(EnquiryRequest enquiryRequest);
    BankResponse creditAccount(CreditAndDebitRequest creditAndDebitRequest);
    BankResponse debitAccount(CreditAndDebitRequest creditAndDebitRequest);
    BankResponse transfer(TransferRequest transferRequest);

    User getUserByEmail(String email);
}
