package vynguyen.employee.api;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Posts;

import static io.restassured.RestAssured.given;

public class Delete {
    static String baseUri = "https://jsonplaceholder.typicode.com";
    static RequestSpecification request = given();
    public static void main (String[] args){

        Posts postBody = new Posts();
        postBody.setUserId(1001);
        postBody.setTitle("King Bob update");
        postBody.setBody("bello lalala");

        deleteAPost(postBody);

//        String body = "{\n" +
//                "    \"userId\": 1327,\n" +
//                "    \"title\": \"bello\",\n" +
//                "    \"body\": \"lalala\"\n" +
//                "  }";
//        postAPost(body);
    }

    public static void deleteAPost(Object body){
        request.baseUri(baseUri);
        request.basePath("/posts");

        Response response = request
                            .headers("Content-type","application/json; charset=UTF-8")
                            .body(body)
                            .delete("/1");
        response.prettyPrint();

    }
}
