package com.jira.openAPI.issue;

import io.restassured.http.Header;
import io.restassured.response.Response;
import utilities.BaseTest;
import utilities.RequestConstants;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;

public class GetJiraIssueInfo extends BaseTest {

    public Response getIssue(String issueKey, Header...header){
        basePath = RequestConstants.PATH_ISSUE;

        Response response = given()
                                .headers(setHeaders(header))
                            .when()
                                 .get(issueKey);

        return response;
    }
}
