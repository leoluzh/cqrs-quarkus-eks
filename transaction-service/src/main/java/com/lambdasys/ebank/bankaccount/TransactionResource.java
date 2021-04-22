package com.lambdasys.ebank.bankaccount;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/api/v1/transactions")
public class TransactionResource {

    private static final String TRANSACTIONS_CHANNEL = "transactions";

    private final Emitter<Transaction> emitter;

    @Inject
    public TransactionResource(
            @Channel(TRANSACTIONS_CHANNEL)
            final Emitter<Transaction> emitter){
        this.emitter = emitter;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional(Transactional.TxType.REQUIRED)
    public Response save(final Transaction transaction){
        transaction.persist();
        emitter.send(transaction);
        return Response.created(URI.create(String.format("/api/v1/transactions/%s",transaction.id))).build();
    }

}



