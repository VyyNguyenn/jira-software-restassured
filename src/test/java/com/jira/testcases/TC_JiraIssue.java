package com.jira.testcases;

import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ProjectInfo;
import com.jira.openAPI.issue.DeleteJiraIssue;
import com.jira.openAPI.issue.GetJiraIssueInfo;
import com.jira.openAPI.issue.PostCreateJiraIssue;

import static utilities.RequestCapabilities.*;

public class TC_JiraIssue {
    String issueTypeID;

    @BeforeClass
    public void selectIssueType(){
        ProjectInfo projectInfo = new ProjectInfo();
        issueTypeID = projectInfo.getIssueTypeID("task");
    }

    @Test
    public void TC_01_Check_Authorization(){
        String randomSummary = RandomStringUtils.random(20, true, true);
        PostCreateJiraIssue createJiraIssue = new PostCreateJiraIssue();
        Response response = createJiraIssue.createIssue(PROJECT_ID,issueTypeID, randomSummary, contentTypeHeader,acceptHeader);
        Assert.assertEquals(response.statusCode(),415);
    }

    @Test
    public void TC_02_Create_Ticket_Successfully(){
        String randomSummary = RandomStringUtils.random(20, true, true);
        PostCreateJiraIssue createJiraIssue = new PostCreateJiraIssue();
        Response response = createJiraIssue.createIssue(PROJECT_ID,issueTypeID,randomSummary, contentTypeHeader, acceptHeader, authorizationHeader);

        Assert.assertEquals(response.statusCode(),201);


        String issueKey = response.then().extract().path("id");
        GetJiraIssueInfo getJiraIssueInfo = new GetJiraIssueInfo();
        Response issueInfo = getJiraIssueInfo.getIssue(issueKey);
        System.out.println(issueKey);


        DeleteJiraIssue deleteJiraIssue = new DeleteJiraIssue();
        Response tearDown = deleteJiraIssue.deleteJiraIssue(issueKey, authorizationHeader);
        Assert.assertEquals(tearDown.statusCode(),204);
        tearDown.prettyPrint();
    }
}
