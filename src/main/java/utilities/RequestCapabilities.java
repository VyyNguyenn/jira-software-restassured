package utilities;

import io.restassured.http.Header;
import java.util.Base64;

public interface RequestCapabilities {
    String email = "vytn101@gmail.com";
    String token = "ATATT3xFfGF0XhGVdQLOrMNtfJXr8DEAQAQTN5BESX5yG7Lix-VGYANyYSBrl5d1gLXEQjXMgflNcOfM332ezlQnD2KLNAWpwGuaXgmKDOQxVRLFKwZ1uGurn9IS_qfq9WFRHXQJO-_bjBo_c51XE5IFFmx-_O4oZlMQ9D_8Kb6N5KEEqOOVeWw=004BE4D5";
    String cred = email.concat(":").concat(token);
    String encodedCred = Base64.getEncoder().encodeToString(cred.getBytes());

    String BASE_URI_PROD = "https://vynguyen-restassured.atlassian.net";
    String PROJECT_ID = "10002";

    Header contentTypeHeader = new Header("Content-Type", "application/json");
    Header acceptHeader = new Header("Accept", "application/json");
    Header authorizationHeader = new Header("Authorization", "Basic " + encodedCred);


}