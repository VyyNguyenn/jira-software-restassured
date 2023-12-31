package com.jira.serviceObjects;

import com.jira.openAPI.project.GetJiraProject;
import io.qameta.allure.Step;
import io.restassured.http.Header;
import io.restassured.response.Response;
import utilities.RequestConstants;

import java.util.List;
import java.util.Map;

public class ProjectService {
    static List<Map<String, String>> issueTypes;

    @Step("Get Jira project info")
    public static Response getProject(Header... header){
        GetJiraProject request = new GetJiraProject();
        Response response = request.getProjectInfo(header);
        return response;
    }

    @Step("Get issue list")
    public static void getIssueTypeList(){
        GetJiraProject projectInfo = new GetJiraProject();
        Response response = projectInfo.getProjectInfo(RequestConstants.authorizationHeader);
        issueTypes = response.then().extract().path("issueTypes");
    }

    @Step("Get issue ID")
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
