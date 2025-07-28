package com.sylvester.bank.utils;

import java.time.Year;

public class AccountUtils {
    public static final  String ACCOUNT_EXISTS_CODE = "001";
    public static final  String ACCOUNT_EXISTS_MESSAGE = "This user already has an account created!";
    public static final  String ACCOUNT_CREATION_SUCCESS = "002";
    public static final  String ACCOUNT_CREATION_MESSAGE = "Account creation successful!";
    public static final String ACCOUNT_NOT_EXIST_CODE = "003";
    public static final String ACCOUNT_NOT_EXISTS_MESSAGE = "This user with the account number does not have an account created!";
    public static final  String ACCOUNT_FOUND_CODE = "004";
    public static final  String ACCOUNT_FOUND_MESSAGE = "This user has an account created!";
    public static final String ACCOUNT_CREDITED_SUCCESS = "005";
    public static final String ACCOUNT_CREDITED_SUCCESS_MESSAGE = "User credited successfully!";
    public static final  String INSUFFICIENT_BALANCE_CODE = "006";
    public static final String INSUFFICIENT_BALANCE_MESSAGE = "Insufficient Balance!";
    public static final String ACCOUNT_DEBITED_SUCCESS = "007";
    public static final String ACCOUNT_DEBITED_SUCCESS_MESSAGE = "Account Debited successfully!";

    public static  String generateAccountNumber() {
        int currentYear = 3135;
        int min = 100000;
        int max = 999999;
        int randNumber = (int)Math.floor(Math.random() * (max - min + 1) + min);
        String year = String.valueOf(currentYear);
        String rand = String.valueOf(randNumber);
        StringBuilder accountNumber = new StringBuilder();
        accountNumber.append(year).append(rand);
        return accountNumber.toString();
    }




}
