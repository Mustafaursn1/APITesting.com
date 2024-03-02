package get_request;

import base_url.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get06b extends ReqresBaseUrl {
    /*
    Given
      https://reqres.in/api/unknown/
    When
      I send GET Request to the URL
    Then
    1)Status code is 200
    2)Print all pantone_values
    3)Print all ids greater than 3 on the console
       Assert that there are 3 ids greater than 3
    4)Print oll names whose ids are less than 3 on the console
      Assert that the number of names whose ids are less than 3 is 3
     */

    //1 Set the Url
    //2 Set the expected Data -->put post path
    //3 Send the Request and Get the Response
    //4 Do Assertion
    @Test
    public void get01() {
        //1 Set the Url
        spec.pathParams("first", "api", "second", "unknown");

        //2 Set the expected Data -->put post path

        //3 Send the Request and Get the Response
        Response response = given().spec(spec).get("/{first}/{second}");
        response.prettyPrint();

        //4 Do Assertion

        //1)Status code is 200
        assertEquals(200, response.getStatusCode());
        //2)Print all pantone_values
        JsonPath jsonPath = response.jsonPath();
        List<String> pantoneValueList = jsonPath.getList("data.pantone_value");
        System.out.println(pantoneValueList);
        System.out.println(pantoneValueList.size());
        //3)Print all ids greater than 3 on the console
        System.out.println("dataIdList:" + jsonPath.getList("data.id"));

        List<Integer> ids = jsonPath.getList("data.findAll{it.id>3}.id");
        System.out.println("ids: " + ids);
        // Assert that there are 3 ids greater than 3
        assertEquals(3, ids.size());

        // 4)Print oll names whose ids are less than 3 on the console

        List<String> names = jsonPath.getList("data.findAll{it.id>3}.name");
        System.out.println("names: " + names);


        // Assert that the number of names whose ids are less than 3 is 3

        assertEquals(3, names.size());


    }


}
