package vynguyen.jira.api;

import builder.CreateIssueJsonDataBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import utilities.RequestCapabilities;

import static io.restassured.RestAssured.given;

public class PostCreateJiraIssue extends RequestCapabilities {

    public Response createIssue(String projectID, String issueTypeID, String summary){
        RequestSpecification request = given();
        request.baseUri("https://vynguyen-restassured.atlassian.net");
        request.basePath("/rest/api/3/issue");

        String body = CreateIssueJsonDataBuilder.build(projectID, issueTypeID, summary);

        Response response = request.log().body()
                                .header(contentTypeHeader)
                                .header(acceptHeader)
                                .header(authorizationHeader)
                                .body(body)
                            .when()
                                 .post();

        return response;
    }

    public Response logCheck(){
        RequestSpecification request = given();
        request.baseUri("https://vynguyen-restassured.atlassian.net");
        request.basePath("/rest/api/3/issue");

        String randomSummary = RandomStringUtils.random(20, true, true);

        String body = CreateIssueJsonDataBuilder.build("10002","10013", randomSummary);

        Response response = request.log().body()
                                .header(contentTypeHeader)
                                .header(acceptHeader)
                                .header(authorizationHeader)
                                .body(body)
                            .when()
                                .post();

        return response;
    }
}
