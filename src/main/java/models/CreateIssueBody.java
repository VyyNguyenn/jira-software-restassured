package models;

public class CreateIssueBody {
    private Fields fields;

    public Fields getFields() {
        return fields;
    }

    public CreateIssueBody(Fields fields){
        this.fields = fields;
    }
    public static class Fields {
        public String getSummary() {
            return summary;
        }

        private IssueType issuetype;
        private Project project;
        private String summary;

        public Fields(IssueType issueType, Project project, String summary) {
            this.issuetype = issueType;
            this.project = project;
            this.summary = summary;
        }

        public IssueType getIssuetype() {
            return issuetype;
        }

        public static class IssueType {
                private String id;

                public IssueType(String issueId) {
                    this.id = issueId;
                }

                public String getId() {
                    return id;
                }
            }

            public static class Project {
                private String id;

                public Project(String projectId) {
                    this.id = projectId;
                }
        }
    }
}

