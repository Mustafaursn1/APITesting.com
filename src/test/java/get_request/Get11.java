package get_request;

import base_url.GoRestBaseUrl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


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
          Rev. Ananta Arora, Mrs. Bhardwaj Naik and Msgr. Ganapati Jha  are among the users
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
                body("meta.pagination.limit", equalTo(10),
                        "meta.pagination.links.current", equalTo("https://gorest.co.in/public/v1/users?page=1"),
                        "data", hasSize(10),
                        "data.status", hasItem("active"),
                        "data.name", hasItems("Msgr. Ganapati Jha", "Mrs. Bhardwaj Naik", "Rev. Ananta Arora"));

        //Kadin ve erkek sayilarini karsilastiralim
        //1.yol
        List<String> genders = response.jsonPath().getList("data.gender");
        int numFemale = 0;
        for (String w : genders) {
            if (w.equalsIgnoreCase("female")) {
                numFemale++;

            }


        }
        System.out.println("Female: " + numFemale);

        assertFalse(numFemale <= genders.size() - numFemale);


        //2.yol Kadin ve erkek sayilarini Groovy ile bulalim

        List<String> femaleNames = response.jsonPath().getList("data.findAll{it.gender=='female'}.name");
        for (String w1 : femaleNames) {
            System.out.println("femaleNames: " + w1);

        }

        List<String> maleNames = response.jsonPath().getList("data.findAll{it.gender=='male'}.name");


        for (String w2 : maleNames) {
            System.out.println("maleNames: " + w2);

        }
        Assert.assertTrue(maleNames.size()<=femaleNames.size());

    }


}
