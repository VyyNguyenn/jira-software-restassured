package vynguyen.employee.api;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetUser {
    static String baseUri = "https://jsonplaceholder.typicode.com";
    static RequestSpecification request = given();

    public static void main (String[] args){
        System.out.println("Get all user");
        //getAllUsers();

        System.out.println("Get user by Id");
        getUserBuId("10");

        String street = getUserBuId("10")
                        .then()
                        .extract().path("address.street");
        System.out.println(street);
    }

    public static Response getAllUsers(){
        request.baseUri(baseUri);
        request.basePath("/users");

        Response response = request.get();
        response.prettyPrint();
        return response;

        //response.then().statusCode(equalTo(111));
    }

    public static Response getUserBuId(String id){
        request.baseUri(baseUri);
        request.basePath("/users");

        Response response = request.get(id);
        response.prettyPrint();
        return response;
    }

}
