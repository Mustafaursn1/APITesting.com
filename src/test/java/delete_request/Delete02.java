package delete_request;

import base_url.JsonPlaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utilities.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Delete02 extends JsonPlaceholderBaseUrl {
    /*
    Given
      https://jsonplaceholder.typicode.com/todos/198
    When
       I send DELETE Request to the Url
    Then
      Status code is 200
      And Response body is { }
*/
  @Test
    public void delete01(){
      //1 set the Url
      spec.pathParams("first","todos","second",198);
      //2 set the expected Data



      //3 send the delete Request and Get the Response
      Response response=given().spec(spec).when().delete("/{first}/{second}");
      response.prettyPrint();

      //Do Assertions
      Map<Object ,Object> actualData= response.as(HashMap.class);
      System.out.println("actualData: "+actualData);
      System.out.println(actualData.size());
      Assert.assertEquals("delete islemei basarisiz",0,actualData.size());




  }






}
