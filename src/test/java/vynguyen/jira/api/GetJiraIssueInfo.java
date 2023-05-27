package vynguyen.jira.api;

import builder.CreateIssueJsonDataBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import utilities.RequestCapabilities;

import static io.restassured.RestAssured.given;

public class GetJiraIssueInfo extends RequestCapabilities {

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
