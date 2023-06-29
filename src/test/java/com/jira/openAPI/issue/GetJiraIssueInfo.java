package com.jira.openAPI.issue;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.RequestCapabilities;

import static io.restassured.RestAssured.given;

public class GetJiraIssueInfo implements RequestCapabilities {

    public Response getIssue(String issueKey){
        RequestSpecification request = given();
        request.baseUri("https://vynguyen-restassured.atlassian.net");
        request.basePath("/rest/api/3/issue");

        Response response = request
                                .header(contentTypeHeader)
                                .header(acceptHeader)
                                .header(authorizationHeader)
                            .when()
                                 .get(issueKey);

        return response;
    }
}
