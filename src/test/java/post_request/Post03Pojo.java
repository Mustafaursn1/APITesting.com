package post_request;

import base_url.JsonPlaceholderBaseUrl;
import org.junit.Test;

public class Post03Pojo  extends JsonPlaceholderBaseUrl {

    /*
    Given
        https://jsonplaceholder.typicode.com/todos
    {
      "userId": 55,
      "title": "Tidy your room",
      "completed": false
    }
   When
     I send POST Request to the Url
   Then
    Status code is 201
   And
    response body is like {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false,
            "id": 201
   }
*/

    @Test
    public void post01(){
        //set the Url
        spec.pathParams("first","todos");
        //set the expected Datda



        //send the request and Get the Response

        //Do Assertion





    }






}
