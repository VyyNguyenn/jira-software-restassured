package com.jira.testcases;

import com.jira.serviceObjects.ProjectService;
import com.jira.openAPI.project.GetJiraProject;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utilities.RequestCapabilities;

public class TC_JiraProject {

    @Test
    public void TC_01_Check_Authorization(){
        Response response = ProjectService.getProject(RequestCapabilities.contentTypeHeader,RequestCapabilities.acceptHeader);
        System.out.println(response.statusCode());
        response.prettyPrint();
    }

    @Test
    public void TC_02_Successfully(){
        Response response = ProjectService.getProject(RequestCapabilities.contentTypeHeader,RequestCapabilities.acceptHeader, RequestCapabilities.authorizationHeader);
        System.out.println(response.statusCode());
        response.prettyPrint();
    }

}
