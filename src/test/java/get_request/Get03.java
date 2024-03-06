package get_request;

import base_url.BaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Get03 extends BaseUrl {

/*
Given https://jsonplaceholder.typicode.com/todos/23
When User send GET Request to the Url
Then HTTP Status Code should be 200
And Response format should be "application/json"
And "title" is "et itaque necessitatibus maxime molestiae qui quas velit"
And "completed" is false
And "userId" is 2
 */

    @Test
    public void get01() {
        //set The URL
        spec.pathParams("first", "todos", "second", 23);

        //set Expected DATA-->suan yok(put,patch, post)

        //Send teh request and Get Response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do Assrertion  Then HTTP Status Code should be 200
        //1.yol Hard Assert
        response.then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
                body("completed", equalTo(false)).
                body("userId", equalTo(2));
        System.out.println("*************************");
        //2.yol  softAssert-->sadece body icinde gecerli
        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed", equalTo(false), "userId", equalTo(2));


    }


}
