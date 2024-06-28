package com.sudipta.stepDefintions;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.Map;

public class ApiSteps {

    String locationId;
    Response weatherResponse;

    @When("User request for the sitelist endpoint to find the location Id for the \"([^\\\"]*)\"$")
    public void user_request_for_the_sitelist_endpint(String loc) {

        RequestSpecification req = RestAssured.given();
        req.baseUri("http://datapoint.metoffice.gov.uk/public/data/");
        req.basePath("val/wxfcs/all/datatype/sitelist");
        req.queryParam("key", "6e7f5e38-3575-46c9-b304-47b3549d276e");

        req.get().then().statusCode(200);
        String res = req.get().asString();

        Map<String, String> attrMap = XmlPath.with(res).get("**.find{it.@name == '" + loc + "'}.attributes()");

        locationId = attrMap.get("id");

    }

    @Then("User find  weather  info for that location Id by requesting weather API")
    public void user_find_weather_info_for_that_location() {

        RequestSpecification req = RestAssured.given();
        req.baseUri("http://datapoint.metoffice.gov.uk/public/data/");

        req.basePath("val/wxfcs/all/xml/" + locationId);

        req.queryParam("res", "3hourly");
        req.queryParam("key", "6e7f5e38-3575-46c9-b304-47b3549d276e");

        weatherResponse = req.get();
        req.get().then().statusCode(200);

    }


    @Then("User assert the \"([^\\\"]*)\" is correct$")
    public void user_assert_the_location_is_correct(String loc) {

        String locResult = XmlPath.with(weatherResponse.asString()).get("SiteRep.DV.Location.@name");
        Assert.assertTrue(locResult.equalsIgnoreCase(loc));

    }

    @Then("the parameter with name S has a description of wind speed")
    public void the_parameter_with_name_s_has_a_description_of_wind_speed() {

        final String param = XmlPath.with(weatherResponse.asString()).get("**.find { it.@name == 'S'}");
        Assert.assertTrue(param.equalsIgnoreCase("Wind Speed"));

    }
}
