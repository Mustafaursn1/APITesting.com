package delete_request;

import base_url.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojo.DummyResponseBodyForDelete;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Delete03 extends DummyRestApiBaseUrl {

    /*
     URL: https://dummy.restapiexample.com/api/v1/delete/2
     HTTP Request Method: DELETE Request
     Test Case: Type by using Gherkin Language
    Assert:
     1) Status code is 2001
     ii) "status" is "success" iii) "dota" is "2"
      iv) "message" is "Successfully! Record has been deleted"
     */
    /*
    Given
     URL: https://dummy.restopiexomple.com/api/v1/delete/2
    When
     User sends Delete Request and gets response
    Then
      1) Status code is 200
    And
      ii) "status" is "success"
    And
      iii) "data" is "2"
    And
       iv) "message" is "Successfully! Record has been deleted"
     */
    /*
    expected Data:
    {
    "status": "success",
    "data": "2",
    "message": "Successfully! Record has been deleted"
    }
     */

    @Test
    public void delete01(){
        //set teh Url
        spec.pathParams("first","delete","second",2);
        //set the expected Data
        DummyResponseBodyForDelete expectedData=new DummyResponseBodyForDelete("success",
                                           2,"Successfully! Record has been deleted");


        //send the Delete Request and Get the Response
        Response response=given().spec(spec).when().delete("/{first}/{second}");
        response.prettyPrint();

        //Do Assertions

        DummyResponseBodyForDelete actualData= ObjectMapperUtils.convertJsonToJava(response.asString(),DummyResponseBodyForDelete.class);
        System.out.println("actualData: "+actualData);


        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getStatus(),actualData.getStatus());
        assertEquals(expectedData.getData(),actualData.getData());
        assertEquals(expectedData.getMessage(),actualData.getMessage());








    }

}
