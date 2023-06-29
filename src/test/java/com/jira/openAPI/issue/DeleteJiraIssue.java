package com.jira.openAPI.issue;

import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.BaseTest;

import static io.restassured.RestAssured.*;

public class DeleteJiraIssue extends BaseTest {

    public Response deleteJiraIssue (String issueKey, Header...header){
        RequestSpecification request = given();
        request.baseUri("https://vynguyen-restassured.atlassian.net");
        request.basePath("/rest/api/3/issue/");

        Response response = request.log().all()
                                .headers(setHeaders(header))
                            .when()
                                .delete(issueKey);
        return response;
    }

}
