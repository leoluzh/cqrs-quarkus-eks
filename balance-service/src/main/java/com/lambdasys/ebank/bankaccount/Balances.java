package com.lambdasys.ebank.bankaccount;

import javax.transaction.Transactional;
import java.util.Optional;

public interface Balances {

    Optional<Balance> findByAccountId(final String accountId);

    @Transactional
    Balance recalculate(final Transaction transaction);

}
