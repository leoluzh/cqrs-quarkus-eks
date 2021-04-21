package com.lambdasys.ebank.bankaccount;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Optional;

@ApplicationScoped
public class BalancesImpl implements Balances , PanacheRepository<Balance> {

    @Override
    public Optional<Balance> findByAccountId(final String accountId) {
        return find("accountId",accountId).singleResultOptional();
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Balance recalculate(final Transaction transaction){

        final var balance = findByAccountId(transaction.getAccountId())
                .orElse(Balance.getInstance(transaction.getAccountId()))
                .recalculate(transaction);

        if(Objects.isNull(balance.id)){
            persist(balance);
        }else{
            update("value = ?1 WHERE id = ?2",balance.value,balance.id);
        }

        return balance;
    }

}

