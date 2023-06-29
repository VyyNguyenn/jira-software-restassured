package builder;

import models.CreateIssueBodyModel;

public class CreateIssueJsonBodyBuilder {
    public static CreateIssueBodyModel createBody;

    public static String build(String projectId, String typeId, String summary){
        CreateIssueBodyModel.Fields.IssueType issueType = new CreateIssueBodyModel.Fields.IssueType();
        issueType.setId(typeId);

        CreateIssueBodyModel.Fields.Project project = new CreateIssueBodyModel.Fields.Project();
        project.setId(projectId);

        CreateIssueBodyModel.Fields fields = new CreateIssueBodyModel.Fields();
        fields.setIssuetype(issueType);
        fields.setProject(project);
        fields.setSummary(summary);

        createBody = new CreateIssueBodyModel();
        createBody.setFields(fields);

        return BodyJsonBuilder.getJsonData(createBody);
    }

    public static CreateIssueBodyModel getCreateBody() {
        return createBody;
    }
}
