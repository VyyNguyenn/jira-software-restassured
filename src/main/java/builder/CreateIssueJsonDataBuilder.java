package builder;

import models.CreateIssueBody;

public class CreateIssueJsonDataBuilder {
    public static CreateIssueBody createBody;

    public static String build(String projectId, String typeId, String summary){
        CreateIssueBody.Fields.IssueType issueType = new CreateIssueBody.Fields.IssueType();
        issueType.setIssueID(typeId);

        CreateIssueBody.Fields.Project project = new CreateIssueBody.Fields.Project();
        project.setProjectID(projectId);

        CreateIssueBody.Fields fields = new CreateIssueBody.Fields();
        fields.setIssuetype(issueType);
        fields.setProject(project);
        fields.setSummary(summary);

        createBody = new CreateIssueBody();
        createBody.setFields(fields);

        return BodyJsonBuilder.getJsonData(createBody);
    }

    public static CreateIssueBody getCreateBody() {
        return createBody;
    }
}
