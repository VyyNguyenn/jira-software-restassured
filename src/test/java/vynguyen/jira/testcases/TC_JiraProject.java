package vynguyen.jira.testcases;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import utilities.RequestCapabilities;
import vynguyen.jira.api.GetJiraProject;

public class TC_JiraProject {

    @Test
    public void TC_01_Check_Authorization(){
        GetJiraProject request = new GetJiraProject();
        Response response = request.getProjectInfo(RequestCapabilities.contentTypeHeader,RequestCapabilities.acceptHeader);
        System.out.println(response.statusCode());
    }

    @Test
    public void TC_02_Successfully(){
        GetJiraProject request = new GetJiraProject();
        Response response = request.getProjectInfo(RequestCapabilities.contentTypeHeader,RequestCapabilities.acceptHeader, RequestCapabilities.authorizationHeader);
        System.out.println(response.statusCode());
    }

}
