package com.lambdasys.ebank.bankaccount;

import io.smallrye.reactive.messaging.kafka.KafkaRecord;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import java.util.UUID;
import java.util.logging.Logger;

@ApplicationScoped
public class TransactionOutgoingProducer {

    private static final String INCOMING_TRANSACTIONS_TOPIC = "transactions" ;
    private static final String OUTGOING_TRANSACTIONS_TOPIC = "transactions" ;

    private final Logger log = Logger.getLogger(TransactionOutgoingProducer.class.getName());

    @Incoming(INCOMING_TRANSACTIONS_TOPIC)
    @Outgoing(OUTGOING_TRANSACTIONS_TOPIC)
    public KafkaRecord<String,Transaction> produce(final Transaction transaction){

        log.info(String.format("Sending transaction id %s with value %s and description %s.",
                transaction.id,
                transaction.value,
                transaction.description));

        //create with correlation id
        return KafkaRecord.of(UUID.randomUUID().toString(),transaction);
    }

}
