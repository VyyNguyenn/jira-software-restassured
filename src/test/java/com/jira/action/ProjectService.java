package com.jira.action;

import com.jira.openAPI.project.GetJiraProject;
import io.restassured.http.Header;
import io.restassured.response.Response;
import utilities.RequestCapabilities;

public class ProjectService {

    public static Response getProject(Header... header){
        GetJiraProject request = new GetJiraProject();
        Response response = request.getProjectInfo(header);
        return response;
    }
}
