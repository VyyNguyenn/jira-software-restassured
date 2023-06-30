package com.jira.openAPI;

import utilities.RequestCapabilities;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
public class GetJiraProjectDraft implements RequestCapabilities {
    public static void main(String[] args){
        RequestSpecification request = given();
        request.baseUri("https://vynguyen-restassured.atlassian.net");
        request.basePath("/rest/api/3/project/REST");

        Response response = request
                                .header(acceptHeader)
                                .header(authorizationHeader)
                            .when()
                                .get();
        //response.prettyPrint();

        String entityId = response
                          .then()
                                .extract().path("entityId");
        String jsonData = response
                          .then()
                                .extract().response().asString();

        //System.out.println(jsonData);
        List<Map<String, String>> issueType = response.then().extract().path("issueTypes");
        System.out.println(issueType);
        Map<String, List<Map<String, String>>> projectInfo = JsonPath.from(response.asString()).get();
        //System.out.println(projectInfo);
        List<Map<String, String>> issueList = projectInfo.get("issueTypes");
        //System.out.println(issueList);

        for(Map<String, String> issue : issueType){
            System.out.println(issue.get("id"));
        }
        given().log().all();
    }
}
