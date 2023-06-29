package utilities;

import io.restassured.response.Response;
import com.jira.openAPI.project.GetJiraProject;

import java.util.List;
import java.util.Map;

public class ProjectInfo {
    private List<Map<String, String>> issueTypes;

    public void getIssueTypeList(){
        GetJiraProject projectInfo = new GetJiraProject();
        Response response = projectInfo.getProjectInfo(RequestCapabilities.authorizationHeader);
        issueTypes= response.then().extract().path("issueTypes");
    }

    public String getIssueTypeID(String issueType){
        getIssueTypeList();
        String issueTypeId = null;
        for(Map<String, String> issue: issueTypes){
            if(issue.get("name").equalsIgnoreCase(issueType)){
                issueTypeId = issue.get("id");
                break;
            }
        }
        return issueTypeId;
    }
}
