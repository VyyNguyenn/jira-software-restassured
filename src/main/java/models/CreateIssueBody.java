package models;

import lombok.Data;

@Data
public class CreateIssueBody {
    private Fields fields;

    @Data
    public static class Fields {
        private IssueType issuetype;
        private Project project;
        private String summary;

        @Data
        public static class IssueType {
            private String issueID;
        }

        @Data
        public static class Project {
            private String projectID;
        }
    }
}


