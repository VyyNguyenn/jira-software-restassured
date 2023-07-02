package com.jira.testcases;

import com.jira.serviceObjects.ProjectService;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utilities.BaseTest;
import utilities.RequestConstants;

public class TC_JiraProject extends BaseTest {


    @Test(groups = {"regression"})
    public void TC_01_Check_Authorization(){
        Response response = ProjectService.getProject(RequestConstants.contentTypeHeader, RequestConstants.acceptHeader);
        System.out.println(response.statusCode());
        response.prettyPrint();
    }

    @Test(groups = {"regression"})
    public void TC_02_Successfully(){
        Response response = ProjectService.getProject(RequestConstants.contentTypeHeader, RequestConstants.acceptHeader, RequestConstants.authorizationHeader);
        System.out.println(response.statusCode());
        response.prettyPrint();
    }

}
