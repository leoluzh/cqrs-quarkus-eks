package com.lambdasys.ebank.bankaccount;

import java.math.BigDecimal;

public class ExpenseCalculator implements Calculator{

    public BigDecimal caculate(BigDecimal balanceValue, BigDecimal transactionValue){
        return balanceValue.subtract(transactionValue);
    }

}
