package builder;

import models.CreateIssueBody;

public class CreateIssueJsonDataBuilder {
    public static CreateIssueBody createBody;
    public static String build(String projectId, String typeId, String summary){
        CreateIssueBody.Fields.IssueType issueType= new CreateIssueBody.Fields.IssueType(typeId);
        CreateIssueBody.Fields.Project project = new CreateIssueBody.Fields.Project(projectId);
        CreateIssueBody.Fields fields = new CreateIssueBody.Fields(issueType, project, summary);
        createBody = new CreateIssueBody(fields);

        return BodyJsonBuilder.getJsonData(createBody);
    }

    public static CreateIssueBody getCreateBody() {
        return createBody;
    }
}
