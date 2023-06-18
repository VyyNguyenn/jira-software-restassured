package vynguyen.jira.api;

import builder.CreateIssueJsonDataBuilder;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.BaseTest;

import static io.restassured.RestAssured.*;

public class PostCreateJiraIssue extends BaseTest {

    public Response createIssue(String projectID, String issueTypeID, String summary, Header...header){
        RequestSpecification request = given();
        request.baseUri("https://vynguyen-restassured.atlassian.net");
        request.basePath("/rest/api/3/issue");

        String body = CreateIssueJsonDataBuilder.build(projectID, issueTypeID, summary);

        Response response = request.log().all()
                                .headers(setHeaders())
                                .body(body)
                            .when()
                                 .post();

        return response;
    }

}
