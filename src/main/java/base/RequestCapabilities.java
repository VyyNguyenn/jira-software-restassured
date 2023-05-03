package base;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.RequestSpecification;

import java.util.Base64;

import static io.restassured.RestAssured.*;

public interface RequestCapabilities {
//    static String email = System.getenv("email");
//    static String token = System.getenv("jiraToken");
//    static String cred = email.concat(":").concat(token);
//    static String encodedCred = Base64.getEncoder().encodeToString(cred.getBytes());

    String email = "vytn101@gmail.com";
    String token = "ATATT3xFfGF0UqLUBw_Ms4KXUy1YZg3Hlwf47cmtqt5TfZOZeR6-Mcv9sHszWaw4Lg1zaCXqNS2qzlZANUANay2K_zGD2z5BHgj_pQoxYQX112j4JmgQuhRHyIRf8zhYTGMGUhO0jajCQtzxe3xr2l-cTwZjOk2fw5eMudQU2jZGW6RuaTzHuXM=B3B0E1EF";
    String cred = email.concat(":").concat(token);
    String encodedCred = Base64.getEncoder().encodeToString(cred.getBytes());
    public static Header acceptHeader = new Header("Accept", "application/json");
    public static Header authorizationHeader = new Header("Authorization", "Basic " + encodedCred);



}
