package models;

import lombok.Data;

@Data
public class CreateIssueBodyModel {
    private Fields fields;

    @Data
    public static class Fields {
        private IssueType issuetype;
        private Project project;
        private String summary;

        @Data
        public static class IssueType {
            private String id;
        }

        @Data
        public static class Project {
            private String id;
        }
    }
}


