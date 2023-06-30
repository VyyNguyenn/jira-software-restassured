package com.jira.testcases;

import com.jira.openAPI.project.GetJiraProject;
import io.restassured.response.Response;
import utilities.RequestCapabilities;


public class Draft {
    public static void main(String[] args){
        //Create Jira ticket
//        String randomSummary = RandomStringUtils.random(20, true, true);
//        String projectID = "10002";
//        String issueTypeID = "10013";
//        PostCreateJiraIssue createIssue = new PostCreateJiraIssue();
//        Response post = createIssue.createIssue(projectID, issueTypeID, randomSummary);
//
//        CreateIssueBody issueBody = CreateIssueJsonDataBuilder.getCreateBody();
//        String expectedSummary = issueBody.getFields().getSummary();
//
//        //post.prettyPrint();
//        //System.out.println(post.getStatusCode());
//
//        //Retrieve Jira ticket
//        String issueKey = "/" + post.then().extract().path("key");
//        GetJiraIssueInfo issue = new GetJiraIssueInfo();
//        Response info = issue.getIssue(issueKey);
//        info.prettyPrint();
//        System.out.println(issueKey);
//        String actualSummary = info.then().extract().path("fields.summary");
//        System.out.println(actualSummary);

        //Verify created ticket
        GetJiraProject getProjectInfo = new GetJiraProject();
        Response info = getProjectInfo.getProjectInfo(RequestCapabilities.contentTypeHeader,RequestCapabilities.acceptHeader, RequestCapabilities.authorizationHeader);
        System.out.println(info.statusCode());
        info.prettyPrint();
           
    }
}
