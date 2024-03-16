package put_request;

import base_url.DummyRestApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojo.DummyRestApiDataPojo;
import pojo.DummyRestApiResponseBodyPojo;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Put02 extends DummyRestApiBaseUrl {
    /*
    Given
       https://dummy.restapiexonple.com/api/v1/update/21
        {
       "employee_name": "Ali Can",
        "employee_salary": 111111,
        "employee_age": 23,
        "profile_image": "Perfect image"
        }
    When
       User sends PUT Request
    Then
       i) Status code is 200
     And
    ii) Response body should be like the following
       {
      "status": "success",
      "data": {
      "employee_name": "Ali Can",
      "employee_salary": 111111,
      "employee_age": 23,
      "profile_image": "Perfect image"
                }
      "message": "Successfully! Record has been updated."
        }
*/
    @Test
    public void put01(){
        spec.pathParams("first","update","second",21);

        DummyRestApiDataPojo expectedData=new DummyRestApiDataPojo("Ali Can",111111,23,"Perfect image",21);

        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().put("/{first}/{second}");

        response.prettyPrint();

        DummyRestApiResponseBodyPojo actualData= ObjectMapperUtils.convertJsonToJava(response.asString(),DummyRestApiResponseBodyPojo.class);
        System.out.println("acatualData: "+actualData);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getEmployee_name(),actualData.getData().getEmployee_name());
        assertEquals(expectedData.getEmployee_salary(),actualData.getData().getEmployee_salary());
        assertEquals(expectedData.getEmployee_age(),actualData.getData().getEmployee_age());
        assertEquals(expectedData.getProfile_image(),actualData.getData().getProfile_image());
        assertEquals(expectedData.getId(),actualData.getData().getId());




    }


}
