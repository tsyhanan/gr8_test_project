package app;

import io.restassured.*;
import io.restassured.config.*;
import io.restassured.http.*;
import io.restassured.response.*;
import io.restassured.specification.*;


public class BreweriesService {
  private static final String BASE_URL = "https://api.openbrewerydb.org/v1/breweries/search";

  public Response searchBreweries(String query, String perPage) {
    RequestSpecification request = RestAssured.given()
            .contentType(ContentType.JSON)
            .baseUri(BASE_URL);
    request.queryParams("query", query, "per_page", perPage);

    // Log request details
    request.log().all();

    Response response = request.get();

    // Log response details
    response.prettyPrint();

    return response;
  }
}
