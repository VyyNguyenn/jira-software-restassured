package utilities;

import io.restassured.http.Header;
import io.restassured.http.Headers;

public class BaseTest {

    public static Headers setHeaders(Header...header) {
        Headers headers = new Headers(header);
        return headers;
    }




}
