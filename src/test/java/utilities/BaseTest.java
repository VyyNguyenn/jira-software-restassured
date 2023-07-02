package utilities;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import static io.restassured.RestAssured.baseURI;

public class BaseTest implements RequestConstants{

    @Parameters({"environment"})
    @BeforeSuite
    public void init(String environment){
       baseURI = getEnvironmentURI(environment);
    }

    public static Headers setHeaders(Header...header) {
        Headers headers = new Headers(header);
        return headers;
    }

    public static String generateRandomString(int length){
        return RandomStringUtils.randomAlphanumeric(length);
    }

    protected String getEnvironmentURI(String environment) {
        String uri = null;
        switch (environment) {
            case "prod":
                uri = BASE_URI_PROD;
                break;
            case "test":
                uri = BASE_URI_TEST;
                break;
            default:
                throw new RuntimeException("Environment is not supported!");
        }
        return uri;
    }

    protected String getPath(String category) {
        String path = null;
        switch (category) {
            case "project":
                path = PATH_PROJECT;
                break;
            case "issue":
                path = PATH_ISSUE;
                break;
            default:
                throw new RuntimeException("API path is not correct");
        }
        return path;
    }
}
