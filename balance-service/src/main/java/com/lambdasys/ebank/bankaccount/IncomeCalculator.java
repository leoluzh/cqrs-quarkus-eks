package com.lambdasys.ebank.bankaccount;

import java.math.BigDecimal;

public class IncomeCalculator implements Calculator {
    public BigDecimal caculate(BigDecimal balanceValue, BigDecimal transactionValue){
        return balanceValue.add(transactionValue);
    }
}
