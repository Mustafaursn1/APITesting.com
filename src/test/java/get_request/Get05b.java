package get_request;

import base_url.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;

public class Get05b extends ReqresBaseUrl {
    /*
    Given
       https://reqres.in/api/unknown/3
    When
     User send a GET request to the URL
    Then
      HTTP Stotus Code should be 200
    And
      Response content type is "application/json; charset=utf-8"
     And
       Response body should be like;(Soft Assertion)
       {
    "data": {
         "id": 3,
         "name": "true red",
         "year": 2002,
         "color": "#BF1932",
         "pantone_value": "19-1664"
     }
      "support": {
          "url": "https://reqres.in/#support-heading",
          "text": "To keep ReqRes free, contributions towards server costs ore appreciated!"
      }
     */

    @Test
    public void get01() {
        //1 set the Url
        spec.pathParams("first", "api", "second", "unknown", "third", 3);
        //set the Expected Data -->put path post

        //Send The Request  and Get the Response
        Response response = given().spec(spec).when().get("/{first}/{second}/{third}");
        response.prettyPrint();

        //Do Aseertion

        SoftAssert softAssert = new SoftAssert();

        JsonPath jsonPath = response.jsonPath();
        System.out.println("Id: " + jsonPath.getInt("data.id"));

        softAssert.assertEquals(response.getStatusCode(), 200, "status code dogrulanmadi");
        softAssert.assertEquals(response.contentType(),"application/json; charset=utf-8","Content Type dogrulanmadi");
        softAssert.assertEquals(jsonPath.getInt("data.id"), 3, "id dogrulanmadi");
        softAssert.assertEquals(jsonPath.getString("data.name"), "true red", "name dogrulanmadi");
        softAssert.assertEquals(jsonPath.getInt("data.year"), 2002, "year degeri dogru degil");
        softAssert.assertEquals(jsonPath.getString("data.color"), "#BF1932", "color degeri dogrulanmadi");
        softAssert.assertEquals(jsonPath.getString("data.pantone_value"), "19-1664", "pantone_value degeri dogrulanmadi");
        softAssert.assertEquals(jsonPath.getString("support.url"), "https://reqres.in/#support-heading", "url dogrulanmdi");
        softAssert.assertEquals(jsonPath.getString("support.text"),
                "To keep ReqRes free, contributions towards server costs are appreciated!",
                "text degeri dogrulanmadi");

        softAssert.assertAll();


    }


}
