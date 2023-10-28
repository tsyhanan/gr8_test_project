package app;

import io.qameta.allure.*;
import io.restassured.response.*;
import org.apache.http.*;

import static org.hamcrest.Matchers.*;

public class BreweriesTestSteps {

  protected BreweriesService breweriesService = new BreweriesService();

  @Step("Search breweries")
  public Response searchBreweries(String query, String perPage) {
    return breweriesService.searchBreweries(query, perPage);
  }

  @Step("Verify search breweries response")
  public void verifyBreweriesResponse(Response response, String query, String perPage) {
    response.then().statusCode(HttpStatus.SC_OK)
            .body("name", everyItem(containsStringIgnoringCase(query)))
            .body("size()", equalTo(Integer.parseInt(perPage)));
  }

  @Step("Verify response is empty")
  public void verifyResponseEmpty(Response response) {
    response.then().statusCode(HttpStatus.SC_OK)
            .body("size()", equalTo(0));
  }

  @Step("Verify response error message")
  public void verifyResponseErrorMessage(Response response, String errorMessage) {
    response.then().statusCode(429)
            .body("message", equalTo(errorMessage));
  }
}
