package post_request;

import base_url.DummyRestApiBaseUrl;
import org.junit.Test;

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



        //send the post Request and Get the Response


        //Do Assertion



    }


}
