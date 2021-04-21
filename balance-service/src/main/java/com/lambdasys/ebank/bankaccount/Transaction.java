package com.lambdasys.ebank.bankaccount;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

public class Transaction implements Serializable {

    private final String accountId;
    private final String description;
    private final TransactionType transactionType;
    private final BigDecimal value;

    public Transaction(
            final String accountId,
            final String description,
            final TransactionType transactionType,
            final BigDecimal value){
        this.accountId = accountId;
        this.description = description;
        this.transactionType = transactionType;
        this.value = value;
    }

    public String getAccountId(){
        return this.accountId;
    }

    public String getDescription(){
        return this.description;
    }

    public TransactionType getTransactionType(){
        return this.transactionType;
    }

    public BigDecimal getValue(){
        return this.value;
    }

    public boolean isIncome(){
        return this.transactionType.isIncome();
    }

    public boolean isExpense(){
        return this.transactionType.isExpense();
    }

    public static Transaction ofMap(final Map<String,Object> map){
        return new Transaction(
                map.get("accountId").toString(),
                map.get("description").toString(),
                TransactionType.valueOf(map.get("type").toString()),
                new BigDecimal(map.get("value").toString())
        );
    }

    public BigDecimal calculate(final Balance balance){
        return this.transactionType.getCalculator().caculate(balance.value,this.value);
    }

}
