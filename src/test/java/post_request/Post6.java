package post_request;

import base_url.DummyRestApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojo.DummyRestApiDataPojo;
import pojo.DummyRestApiResponseBodyPojo;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;

public class Post6 extends DummyRestApiBaseUrl {

    /*
       URL: https://dummy.restapiexample.com/api/v1/create
       HTTP Request Method: POST Request
     Request body:{
              "employee_name": "Tom Hanks",
              "employee_salary": 111111,
              "employee_age": 23,
              "profile_image": "Perfect image",
              "id": 4891
               }
Test Case: Type by using Gherkin Language
Assert：
        i) Status code is 200
        ii) Response body should be like the following
         {
        "status": "success",
         "data": {
              "employee_name": "Tom Hanks",
              "employee_salary": 111111,
              "employee_age": 23,
              "profile_image": "Perfect image",
             "id": 4891
             }
        "message": "Successfully! Record has been added."
        }
 */
    /*
    Test Case:
    Given URL: https://dummy.restapiexample.com/api/v1/create
    HTTP Request Method: POST Request
     Request body:{
              "employee_name": "Tom Hanks",
              "employee_salary": 111111,
              "employee_age": 23,
              "profile_image": "Perfect image",
              "id": 4891
               }
      When User sends Post Request

       Then
            Status code is 200
        And
             Response body should be like the following:
        {
        "status": "success",
         "data": {
              "employee_name": "Tom Hanks",
              "employee_salary": 111111,
              "employee_age": 23,
              "profile_image": "Perfect image",
             "id": 4891
             }
        "message": "Successfully! Record has been added."
        }



     */

    @Test
    public void post01(){
        //set the Url
        spec.pathParams("first","create");

        //set the expected Data
        DummyRestApiDataPojo innerPojo=new DummyRestApiDataPojo("Tom Hanks",111111,23,"Perfect image",4891);
        DummyRestApiResponseBodyPojo expectedData=new DummyRestApiResponseBodyPojo("success",innerPojo,"Successfully! Record has been added.");
        System.out.println("expectedData: "+expectedData);

        //send the post Request and Get the Response

        Response response=given().spec(spec).contentType(ContentType.JSON).body(innerPojo).when().post("/{first}");
        response.prettyPrint();




        //Do Assertion
        DummyRestApiResponseBodyPojo actualData= ObjectMapperUtils.convertJsonToJava(response.asString(),DummyRestApiResponseBodyPojo.class);
        System.out.println("actualData: "+actualData);

        Assert.assertEquals(200,response.statusCode());






    }


}
