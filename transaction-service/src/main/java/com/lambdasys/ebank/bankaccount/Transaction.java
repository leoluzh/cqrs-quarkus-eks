package com.lambdasys.ebank.bankaccount;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name="transactions")
public class Transaction extends PanacheEntityBase {

    private static final String GENERATOR_NAME = "UUID";
    private static final String GENERATOR_STRATEGY = "org.hibernate.id.UUIDGenerator";

    @Id
    @GeneratedValue(generator = GENERATOR_NAME)
    @GenericGenerator(name=GENERATOR_NAME,strategy = GENERATOR_STRATEGY)
    @Column(name="id",updatable = false, nullable = false)
    public String id;

    @NotBlank
    @Column(name="account_id")
    public String accountId;

    @NotBlank
    @Column(name="description")
    public String description;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="type")
    public TransactionType type;

    @NotNull
    @Column(name="value")
    public BigDecimal value;


}
