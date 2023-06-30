package com.jira.testcases;

import com.jira.serviceObjects.IssueService;
import com.jira.serviceObjects.ProjectService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.provider.RequestBodyData;

import static utilities.RequestCapabilities.*;

public class TC_JiraIssue {
    String issueTypeID;

    @Test(dataProvider = "issueBody", dataProviderClass = RequestBodyData.class)
    public void TC_01_Check_Authorization(String type, String summary){
        issueTypeID = ProjectService.getIssueTypeID(type);
        Response response = IssueService.createIssue(issueTypeID, summary, contentTypeHeader,acceptHeader);
        Assert.assertEquals(response.statusCode(),415);
    }

    @Test(dataProvider = "issueBody", dataProviderClass = RequestBodyData.class)
    public void TC_02_Create_Ticket_Successfully(String type, String summary){
        issueTypeID = ProjectService.getIssueTypeID(type);
        Response response = IssueService.createIssue(issueTypeID, summary, contentTypeHeader, acceptHeader, authorizationHeader);
        Assert.assertEquals(response.statusCode(),201);

        String issueKey = IssueService.getIssueKey(response);
        Response tearDown = IssueService.deleteIssue(issueKey);
        Assert.assertEquals(tearDown.statusCode(),204);
        tearDown.prettyPrint();
    }
}
