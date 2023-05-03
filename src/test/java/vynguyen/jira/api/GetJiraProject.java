package vynguyen.jira.api;

import base.RequestCapabilities;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Base64;

import static io.restassured.RestAssured.*;
public class GetJiraProject implements RequestCapabilities {
    public static void main(String[] args){
        RequestSpecification request = given();
        request.baseUri("https://vynguyen-restassured.atlassian.net");
        request.basePath("/rest/api/3/project/REST");

        Response response = request
                                .header(acceptHeader)
                                .header(authorizationHeader)
                            .when()
                                .get();
        response.prettyPrint();
    }
}
