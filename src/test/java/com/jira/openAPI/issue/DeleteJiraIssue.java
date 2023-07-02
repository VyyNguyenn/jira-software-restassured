package com.jira.openAPI.issue;

import io.restassured.http.Header;
import io.restassured.response.Response;
import utilities.BaseTest;
import utilities.RequestConstants;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;

public class DeleteJiraIssue extends BaseTest {

    public Response deleteJiraIssue (String issueKey, Header...header){
        basePath = RequestConstants.PATH_ISSUE;

        Response response = given().log().all()
                                .headers(setHeaders(header))
                            .when()
                                .delete(issueKey);
        return response;
    }

}
