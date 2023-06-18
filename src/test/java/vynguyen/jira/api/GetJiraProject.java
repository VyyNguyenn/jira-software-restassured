package vynguyen.jira.api;

import io.restassured.http.Header;
import utilities.BaseTest;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class GetJiraProject extends BaseTest {
    public Response getProjectInfo(Header...header){
        RequestSpecification request = given();
        request.baseUri("https://vynguyen-restassured.atlassian.net");
        request.basePath("/rest/api/3/project/REST");

        Response response = request
                                .headers(setHeaders(header))
                            .when()
                                .get();
        return response;
    }
}
