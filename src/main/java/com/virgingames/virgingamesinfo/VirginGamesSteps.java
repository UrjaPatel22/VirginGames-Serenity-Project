package com.virgingames.virgingamesinfo;

import com.virgingames.constants.EndPoints;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class VirginGamesSteps {
    @Step("Getting all the JackPot information")
    public ValidatableResponse getAllData() {
        return SerenityRest.given().log().all()
                .queryParam("currency","GBP")
                .when()
                .get(EndPoints.GET_ALL_JACKPOT)
                .then();
    }



}
