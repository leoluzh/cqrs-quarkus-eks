package com.lambdasys.ebank.bankaccount;

public class InvalidAccountIdException extends Exception {

    public InvalidAccountIdException(final String accountId){
        super(String.format("Invalid account id %s",accountId));
    }

}
