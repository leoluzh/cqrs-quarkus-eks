package com.lambdasys.ebank.bankaccount;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Entity
@Table(name="balances")
public class Balance extends PanacheEntityBase {

    private static final String GENERATOR_NAME = "UUID";
    private static final String GENERATOR_STRATEGY = "org.hibernate.id.UUIDGenerator";

    public Balance(){

    }

    public Balance(final String id ){
        this(id,null,null);
    }

    public Balance(final String id, final String accountId){
        this(id,accountId,null);
    }

    public Balance(final String id, final String accountId, final BigDecimal value){
        this.id = id;
        this.accountId = accountId;
        this.value = value;
    }

    @Id
    @GeneratedValue(generator = GENERATOR_NAME)
    @GenericGenerator(name = GENERATOR_NAME, strategy = GENERATOR_STRATEGY)
    @Column(name="id",updatable = false, nullable = false)
    public String id;

    @NotBlank
    @Column(name = "account_id")
    public String accountId;

    @Column(name="value")
    public BigDecimal value;

    public Balance recalculate(final Transaction transaction){
        this.value = transaction.calculate(this);
        return this;
    }

    public static Balance getInstance(final String accountId){
        return new Balance(null,accountId);
    }

    public static Balance getInstance(final String accountId, final BigDecimal value){
        return new Balance(null,accountId,value);
    }

}
