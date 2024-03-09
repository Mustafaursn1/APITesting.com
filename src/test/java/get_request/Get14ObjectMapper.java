package get_request;

import base_url.JsonPlaceholderBaseUrl;
import org.junit.Test;

public class Get14ObjectMapper extends JsonPlaceholderBaseUrl {

    /*
    Given
      https://jsonplaceholder.tupicode.com/todos/198
    When
       I send GET Request to the URL
    Then
      Status code is 200
    And response body is like
       {
        "userId": 10,
        "id": 198,
        "titte" "quis elus est sint explicabo",
        "completed": true
        }


     */

    @Test
    public void get01(){
        //Send the url
        spec.pathParams("first","todos","second",198);

        //2 set the Expected Data and get the Response


        //3 send the get request and Get the Response

        //4 DO Assertions


    }




}
