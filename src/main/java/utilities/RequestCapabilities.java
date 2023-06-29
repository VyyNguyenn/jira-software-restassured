package utilities;

import io.restassured.http.Header;
import java.util.Base64;

public interface RequestCapabilities {
    String email = System.getenv("email");
    String token = System.getenv("jiraToken");
    String cred = email.concat(":").concat(token);
    String encodedCred = Base64.getEncoder().encodeToString(cred.getBytes());

    String PROJECT_ID = "10002";

    Header contentTypeHeader = new Header("Content-Type", "application/json");
    Header acceptHeader = new Header("Accept", "application/json");
    Header authorizationHeader = new Header("Authorization", "Basic " + encodedCred);

}