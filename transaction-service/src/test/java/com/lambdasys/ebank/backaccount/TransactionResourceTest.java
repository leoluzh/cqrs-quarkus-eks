package com.lambdasys.ebank.backaccount;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

//@QuarkusTest
public class TransactionResourceTest {

    //@Test
    void testFindByAccoundId(){
        given()
                .when()
                .post("/transaction-service/api/v1/transactions/")
                .then()
                .statusCode(401);
    }

}
