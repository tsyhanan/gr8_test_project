
gr8_test_project
created by Andrii Tsyhanko

Project Documentation:
TestNG,
Allure Report,
Rest Assured

Project Requirements:
Java 17,
Maven Apache

Run Project:
mvn clean test

Generate Allure Report:
allure serve


Task 1: Search Breweries.
I've used the "classes of equivalence" and "boundary values"
test design techniques to create test cases for a scenario that involves two query
parameters: query and per_page.
In this context, implementing TestNG data providers is a beneficial approach to streamline and parameterize the tests.

Due to the lack of clearly defined requirements and the labor-intensive nature of thoroughly researching
the detailed functionality and behavior of the provided endpoint, the implemented tests incorporate a simplified
and approximate parameters list primarily for illustrative purposes.

Test Cases:
 - 1.Search breweries by valid query parameters test case - implemented
 - 2.Search breweries by invalid query parameters test case - implemented
 - 3.Search breweries when perPage parameter exceeded limit test case - implemented

Based on the existing or available requirements, I would proceed to implement the following test cases:
 - 4.Valid Query, Default Per Page
 - 5.Valid Query, No Per Page Specified
Negative Test Cases:
 - 6.Invalid Query (Not Found)
 - 7.Invalid Query (Empty)
 - 8.Invalid Per Page Value (Negative)

I have implemented validations that check whether the received information aligns with the search criteria.
It is not practical to validate the entire content as the data within it is dynamic and can be changed.
In my experience, validations of entire content are particularly meaningful for HTTP GET methods,
as Search methods are typically built upon the GET method for their implementation.


Task 2: List Breweries.
To test this method effectively, I would also utilize the "equivalence classes"
and "boundary values" test design techniques for each query parameter.
Also, I would use a data provider with different sets of input data.
This approach will allow efficiently cover a wide range of scenarios and ensure
that the API behaves correctly under various conditions.

Some example scenarios might include:
- Testing the default behavior with no filters.
- Filtering breweries by city, state, name, type, postal code, and more.
- Sorting results in ascending and descending order.
- Paging through the results using page and per_page.
- Filtering by distance using by_dist and specifying latitude and longitude.
- Filtering by brewery IDs using by_ids.
- Testing the response for invalid inputs.
- Testing the use of per_page with each filter.

The estimated effort for automating the "List Breweries" method depends on several factors,
including the complexity of the API,
the number of test scenarios, and the depth of testing.
However, here's a rough estimate:
- Test Scenario Identification and Test Data Preparation: 4-6 hours
- Test Automation Framework Setup: 2-4 hours
- Test Script Development: 15-25 hours (may vary depending on the number of scenarios)
- Execution and Debugging: 6-10 hours
- Error Handling and Reporting: 3-5 hours
- Total Estimated Effort: 30-50 hours (may vary)
  Keep in mind that these estimates are approximate and can vary based on team's experience and the complexity of the API.
  Additionally, it's important to regularly maintain and update automated tests as the API evolves.






















