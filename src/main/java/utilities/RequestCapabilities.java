package utilities;

import io.restassured.http.Header;
import java.util.Base64;

public class RequestCapabilities {
    static String email = System.getenv("email");
    static String token = System.getenv("jiraToken");
    static String cred = email.concat(":").concat(token);
    static String encodedCred = Base64.getEncoder().encodeToString(cred.getBytes());

    public static Header contentTypeHeader = new Header("Content-Type", "application/json");
    public static Header acceptHeader = new Header("Accept", "application/json");
    public static Header authorizationHeader = new Header("Authorization", "Basic " + encodedCred);



}
