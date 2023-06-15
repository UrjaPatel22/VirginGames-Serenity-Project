package com.virgingames.virgingamesinfo;

import com.virgingames.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

@RunWith(SerenityRunner.class)
public class virginGamesCRUDTestWithSteps extends TestBase {
   public static ValidatableResponse response;
    @Steps
    VirginGamesSteps virginGamesSteps;

    @Title("This Will displayed all the Jackpot data ")
    @Test
    public  void test001(){
         response = virginGamesSteps.getAllData().statusCode(200).log().all();
    }

    @Title("Verify if currency is GBP")
    @Test
    public void test002() {
        response = virginGamesSteps.getAllData();
        HashMap<String, Object> listOfJackpot = response.extract().path("data.pots[0]");
        System.out.println("List: " + listOfJackpot);
        System.out.println("Record" + listOfJackpot.size());
        Assert.assertThat(listOfJackpot, hasValue("GBP"));

    }
    

}
