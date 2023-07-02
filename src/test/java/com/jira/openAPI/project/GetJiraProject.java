package com.jira.openAPI.project;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import utilities.BaseTest;
import utilities.RequestConstants;

import static io.restassured.RestAssured.given;

public class GetJiraProject extends BaseTest {

    public Response getProjectInfo(Header...header){
        RestAssured.basePath = RequestConstants.PATH_PROJECT;

        return given()
                    .headers(setHeaders(header))
                .when()
                    .get();

    }
}
