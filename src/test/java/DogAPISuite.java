import core.Path;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tools.RestUtil;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class DogAPISuite {

    private ResponseSpecification responseSpecification;
    private RequestSpecification requestSpecification;

    @BeforeTest(groups = "test-group")
    public void setup() {
        requestSpecification = RestUtil.getRequestSpecification();
        requestSpecification.baseUri(Path.DOG_API);

        responseSpecification = RestUtil.getResponseSpecification();

    }

    @Test(groups = "test-group",testName = "List All Breeds")
    public void getAllBreeds() {
        given()
                .spec(requestSpecification.basePath(Path.ALL_BREEDS))
        .when()
                .get(Path.LIST_ALL_BREEDS_END_POINT)
        .then()
                .spec(responseSpecification)
                .log()
                .body();
    }

    @Test(groups = "test-group",testName = "Random Image",dependsOnMethods = "getAllBreeds")
    public void getRandomImage() {
        given()
                .spec(requestSpecification.basePath(Path.ALL_BREEDS))
        .when()
                .get(Path.RANDOM_IMAGE_END_POINT)
        .then()
                .spec(responseSpecification)
                .log()
                .body();
    }
}
