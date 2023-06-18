package vynguyen.jira.testcases;

import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.RequestCapabilities;
import vynguyen.jira.api.DeleteJiraIssue;
import vynguyen.jira.api.GetJiraIssueInfo;
import vynguyen.jira.api.PostCreateJiraIssue;

public class TC_JiraTicket {

    @Test
    public void TC_01_Check_Authorization(){
        String randomSummary = RandomStringUtils.random(20, true, true);
        PostCreateJiraIssue createJiraIssue = new PostCreateJiraIssue();
        Response response = createJiraIssue.createIssue(RequestCapabilities.PROJECT_ID,"10013",randomSummary,
                                                        RequestCapabilities.contentTypeHeader,RequestCapabilities.acceptHeader);
        Assert.assertEquals(response.statusCode(),415);
    }

    @Test
    public void TC_02_Create_Ticket_Successfully(){
        String randomSummary = RandomStringUtils.random(20, true, true);
        PostCreateJiraIssue createJiraIssue = new PostCreateJiraIssue();
        Response response = createJiraIssue.createIssue(RequestCapabilities.PROJECT_ID,"10013",randomSummary,
                                                        RequestCapabilities.contentTypeHeader,RequestCapabilities.acceptHeader,RequestCapabilities.authorizationHeader);

        Assert.assertEquals(response.statusCode(),201);


        String issueKey = response.then().extract().path("id");
        GetJiraIssueInfo getJiraIssueInfo = new GetJiraIssueInfo();
        Response issueInfo = getJiraIssueInfo.getIssue(issueKey);
        System.out.println(issueKey);


        DeleteJiraIssue deleteJiraIssue = new DeleteJiraIssue();
        Response tearDown = deleteJiraIssue.deleteJiraIssue(issueKey,RequestCapabilities.authorizationHeader);
        Assert.assertEquals(tearDown.statusCode(),204);
        tearDown.prettyPrint();
    }
}
