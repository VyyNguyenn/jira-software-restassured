package vynguyen.employee.api;

import com.google.gson.Gson;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Posts;

import static io.restassured.RestAssured.*;
public class PostSomePosts {

    public static void main (String[] args){

       String baseUri = "https://jsonplaceholder.typicode.com";
       RequestSpecification request = given();

       request.baseUri(baseUri);
       request.basePath("/posts");

        /*Posts postBody = new Posts();
        postBody.setUserId(1001);
        postBody.setTitle("King Bob update");
        postBody.setBody("bello lalala");*/

        Posts postBody = new Posts();
        postBody.setUserId(1001);
        postBody.setTitle("King Bob update");
        postBody.setBody("bello lalala");


        Response response = request
                            .header("Content-type","application/json; charset=UTF-8")
                            .body(postBody)
                            .post();
        System.out.println(response.statusCode());
        response.peek();
    }


}
