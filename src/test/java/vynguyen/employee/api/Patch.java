package vynguyen.employee.api;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Posts;

import static io.restassured.RestAssured.given;

public class Patch {
    static String baseUri = "https://jsonplaceholder.typicode.com";
    static RequestSpecification request = given();
    public static void main (String[] args){

        Posts postBody = new Posts();
        postBody.setUserId(1001);
        postBody.setTitle("King Bob update");
        //postBody.setBody("bello lalala");

        putAPost(postBody);

//        String body = "{\n" +
//                "    \"userId\": 1327,\n" +
//                "    \"title\": \"bello\",\n" +
//                "    \"body\": \"lalala\"\n" +
//                "  }";
//        postAPost(body);
    }

    public static void putAPost(Object body){
        request.baseUri(baseUri);
        request.basePath("/posts");

        Response response = request
                            .headers("Content-type","application/json; charset=UTF-8")
                            .body(body)
                            .put("/1");
        response.prettyPrint();

    }
}
