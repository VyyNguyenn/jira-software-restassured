package com.jira.serviceObjects;

import com.jira.openAPI.project.GetJiraProject;
import io.restassured.http.Header;
import io.restassured.response.Response;
import utilities.RequestCapabilities;

import java.util.List;
import java.util.Map;

public class ProjectService {
    static List<Map<String, String>> issueTypes;

    public static Response getProject(Header... header){
        GetJiraProject request = new GetJiraProject();
        Response response = request.getProjectInfo(header);
        return response;
    }

    public static void getIssueTypeList(){
        GetJiraProject projectInfo = new GetJiraProject();
        Response response = projectInfo.getProjectInfo(RequestCapabilities.authorizationHeader);
        issueTypes = response.then().extract().path("issueTypes");
    }

    public static String getIssueTypeID(String issueType){
        getIssueTypeList();
        String issueTypeId = null;
        for(Map<String, String> issue: issueTypes){
            if(issue.get("name").equalsIgnoreCase(issueType)){
                issueTypeId = issue.get("id");
                break;
            }
        }
        return issueTypeId;
    }}
