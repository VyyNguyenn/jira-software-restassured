package com.jira.serviceObjects;

import com.jira.openAPI.issue.DeleteJiraIssue;
import com.jira.openAPI.issue.PostCreateJiraIssue;
import io.qameta.allure.Step;
import io.restassured.http.Header;
import io.restassured.response.Response;

import static utilities.RequestConstants.PROJECT_ID;
import static utilities.RequestConstants.authorizationHeader;

public class IssueService {

    @Step("Create Jira issue")
    public static Response createIssue(String issueTypeID, String summary, Header...header){
        PostCreateJiraIssue createJiraIssue = new PostCreateJiraIssue();
        Response response = createJiraIssue.createIssue(PROJECT_ID, issueTypeID, summary, header);
        return response;
    };

    @Step("Get issue key")
    public static String getIssueKey(Response response){
        String issueKey = response.then().extract().path("id");
        return issueKey;
    };

    @Step("Delete issue")
    public static Response deleteIssue(String issueKey){
        DeleteJiraIssue deleteJiraIssue = new DeleteJiraIssue();
        Response response = deleteJiraIssue.deleteJiraIssue(issueKey, authorizationHeader);
        return response;
    };
}
