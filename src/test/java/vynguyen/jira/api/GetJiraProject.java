package vynguyen.jira.api;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Base64;

import static io.restassured.RestAssured.*;
public class GetJiraProject {
    public static void main(String[] args){
        RequestSpecification request = given();
        request.baseUri("https://vynguyen-restassured.atlassian.net");
        request.basePath("/rest/api/3/project/REST");

        String email = "vytn101@gmail.com";
        String token = "ATATT3xFfGF0UqLUBw_Ms4KXUy1YZg3Hlwf47cmtqt5TfZOZeR6-Mcv9sHszWaw4Lg1zaCXqNS2qzlZANUANay2K_zGD2z5BHgj_pQoxYQX112j4JmgQuhRHyIRf8zhYTGMGUhO0jajCQtzxe3xr2l-cTwZjOk2fw5eMudQU2jZGW6RuaTzHuXM=B3B0E1EF";
        String cred = email.concat(":").concat(token);
        String encodedCred = Base64.getEncoder().encodeToString(cred.getBytes());

        Response response = request
                                .header("Accept", "application/json")
                                .header("Authorization", "Basic " + encodedCred)
                            .when()
                                .get();
        response.prettyPrint();
    }
}
