
import app.BreweriesTestSteps;
import io.restassured.response.*;
import org.testng.annotations.*;


public class SearchBreweriesTests {
  public BreweriesTestSteps breweriesTestSteps = new BreweriesTestSteps();

  public final String ERROR_MESSAGE = "Concurrent request limit exceeded. Please delay concurrent calls using debounce or throttle.";

  @DataProvider(name = "validQueryParams")
  public Object[][] validQueryParams() {
    return new Object[][]{
            {"dog", "1"},
            {"Hotel", "2"},
            {"B", "50"},
            {"1", "100"},
            {"Running Dogs Brewery", "10000"},
    };
  }

  @DataProvider(name = "invalidQueryParams")
  public Object[][] invalidQueryParams() {
    return new Object[][]{
            {"", "0"},
            {" ", "2"},
            {".", "50"},
            {"!", "100"},
            {"#", "10000"},
    };
  }

  @Test(description = "Search breweries by valid query parameters test case",dataProvider = "validQueryParams")
  public void searchBreweriesTestCaseByValidQuery(String query, String perPage) {
    Response response = breweriesTestSteps.searchBreweries(query,perPage);
    breweriesTestSteps.verifyBreweriesResponse(response, query, perPage);
  }

  @Test(description = "Search breweries by invalid query parameters test case",dataProvider = "invalidQueryParams")
  public void searchBreweriesTestCaseByInvalidQuery(String query, String perPage) {
    Response response = breweriesTestSteps.searchBreweries(query,perPage);
    breweriesTestSteps.verifyResponseEmpty(response);
  }

  @Test(description = "Search breweries when perPage parameter exceeded limit test case")
  public void searchBreweriesTestCaseByInvalidPerPageValue() {
    Response response = breweriesTestSteps.searchBreweries("dog","10001");
    breweriesTestSteps.verifyResponseErrorMessage(response, ERROR_MESSAGE);
  }
}
