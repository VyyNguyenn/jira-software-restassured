package base;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.RequestSpecification;

import java.util.Base64;

import static io.restassured.RestAssured.*;

public interface RequestCapabilities {
    static String email = System.getenv("email");
    static String token = System.getenv("jiraToken");
    static String cred = email.concat(":").concat(token);
    static String encodedCred = Base64.getEncoder().encodeToString(cred.getBytes());

    public static Header acceptHeader = new Header("Accept", "application/json");
    public static Header authorizationHeader = new Header("Authorization", "Basic " + encodedCred);



}
