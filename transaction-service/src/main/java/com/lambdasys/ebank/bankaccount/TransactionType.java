package com.lambdasys.ebank.bankaccount;

public enum TransactionType {

    INCOME("income transaction"),
    EXPENSE("expense transaction");

    TransactionType(final String description){
        this.description = description;
    }

    private final String description;

    public String getDescription(){
        return this.description;
    }

}
