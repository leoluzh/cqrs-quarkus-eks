package com.lambdasys.ebank.bankaccount;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

//@QuarkusTest
public class BalanceResourceTest {

    //@Test
    void testFindByAccoundId(){
        given()
                .when()
                .get("/balance-service/api/v1/balances/1")
                .then()
                .statusCode(200);
    }

}
