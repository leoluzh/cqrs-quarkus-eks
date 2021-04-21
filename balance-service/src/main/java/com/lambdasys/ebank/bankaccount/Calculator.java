package com.lambdasys.ebank.bankaccount;

import java.math.BigDecimal;

@FunctionalInterface
public interface Calculator {
    public BigDecimal caculate(BigDecimal balance, BigDecimal transaction);
}
