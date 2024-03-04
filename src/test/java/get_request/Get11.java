package get_request;

import base_url.GoRestBaseUrl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;



public class Get11 extends GoRestBaseUrl {
    
    /*
    !!!Burdaki test datalari anlik degisir.Calistirmadan önce endpoint e
    gidip aktual datalari alip bunun üzerine  datalarimizi güncelleyerek devam etmeliyiz!!!!!

    Given
        https://gorest.co.in/public/v1/users
     When
        User send GET Request
     Then
         The value of "pagination limit" is 10
     And
         The "current link" should be "https://qorest.co.in/public/v1/users?page=1"
      And
          The humber of users should be 10
      And
          We have ot least one "active" status
      And
          Heema Achari, Nawal Banerjee and Ekaaksh Nambeesan  are among the users
      And
         The female users are less than or equals to male users.
*/

    @Test
    public void get01() {
        //set The Url
        spec.pathParam("first", "users");

        //send the expected Data

        //3.send the Request and Get the Response
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();
        //do Assertion

        response.then().
                assertThat().
                statusCode(200).
                body("meta.pagination.limit",equalTo(10),
                        "meta.pagination.links.current",equalTo("https://gorest.co.in/public/v1/users?page=1"),
                        "data",hasSize(10),
                       "data.status",hasItem("active"),
                        "data.name",hasItems("Heema Achari", "Nawal Banerjee" , "Ekaaksh Nambeesan"));


    }


}
