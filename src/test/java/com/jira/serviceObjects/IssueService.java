package com.jira.serviceObjects;

import com.jira.openAPI.issue.DeleteJiraIssue;
import com.jira.openAPI.issue.PostCreateJiraIssue;
import io.restassured.http.Header;
import io.restassured.response.Response;

import static utilities.RequestCapabilities.*;
import static utilities.RequestCapabilities.authorizationHeader;

public class IssueService {

    public static Response createIssue(String issueTypeID, String summary, Header...header){
        PostCreateJiraIssue createJiraIssue = new PostCreateJiraIssue();
        Response response = createJiraIssue.createIssue(PROJECT_ID, issueTypeID, summary, header);
        return response;
    };

    public static String getIssueKey(Response response){
        String issueKey = response.then().extract().path("id");
        return issueKey;
    };

    public static Response deleteIssue(String issueKey){
        DeleteJiraIssue deleteJiraIssue = new DeleteJiraIssue();
        Response response = deleteJiraIssue.deleteJiraIssue(issueKey, authorizationHeader);
        return response;
    };
}
