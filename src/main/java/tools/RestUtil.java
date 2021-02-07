package tools;

import core.Path;
import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;

public class RestUtil {

    public static RequestSpecBuilder requestSpecBuilder;
    public static RequestSpecification requestSpecification;

    public static ResponseSpecBuilder responseSpecBuilder;
    public static ResponseSpecification responseSpecification;

    public static RequestSpecification getRequestSpecification() {

        requestSpecBuilder = new RequestSpecBuilder();

        requestSpecification = requestSpecBuilder.build();

        return requestSpecification;
    }


    public static ResponseSpecification getResponseSpecification() {

        responseSpecBuilder = new ResponseSpecBuilder();
        //responseSpecBuilder.expectResponseTime(lessThan(2L), TimeUnit.SECONDS);
        responseSpecBuilder.expectStatusCode(200); //HTTP ( 200 OK )
        responseSpecification = responseSpecBuilder.build();

        return responseSpecification;
    }
}
