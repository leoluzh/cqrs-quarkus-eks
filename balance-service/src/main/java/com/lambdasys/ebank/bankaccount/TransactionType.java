package com.lambdasys.ebank.bankaccount;

public enum TransactionType {

    INCOME("income transaction", new IncomeCalculator()) ,
    EXPENSE("expense transaction", new ExpenseCalculator());

    TransactionType(final String description, final Calculator calculator){
        this.description = description;
        this.calculator = calculator;
    }

    private final Calculator calculator;
    private final String description;

    public String getDescription(){
        return this.description;
    }

    public boolean isIncome(){
        return INCOME == this;
    }

    public boolean isNotIncome(){
        return INCOME != this;
    }

    public boolean isExpense(){
        return EXPENSE == this;
    }

    public boolean isNotExpense(){
        return EXPENSE != this;
    }

    public boolean is( TransactionType a , TransactionType b ){
        return a == b;
    }

    public boolean isNot( TransactionType a , TransactionType b ){
        return a != b;
    }

    public Calculator getCalculator(){
        return calculator;
    }

}
