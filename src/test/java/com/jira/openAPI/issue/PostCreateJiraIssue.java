package com.jira.openAPI.issue;

import builder.CreateIssueJsonBodyBuilder;
import io.restassured.http.Header;
import io.restassured.response.Response;
import utilities.BaseTest;
import utilities.RequestConstants;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;

public class PostCreateJiraIssue extends BaseTest {

    public Response createIssue(String projectID, String issueTypeID, String summary, Header...header){
        basePath = RequestConstants.PATH_ISSUE;

        String body = CreateIssueJsonBodyBuilder.build(projectID, issueTypeID, summary);

        Response response = given().log().all()
                                .headers(setHeaders(header))
                                .body(body)
                            .when()
                                 .post();

        return response;
    }

}
