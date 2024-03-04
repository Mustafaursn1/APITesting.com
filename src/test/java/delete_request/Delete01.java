package delete_request;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import testData.JsonPlaceholderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Delete01 extends JsonplaceholderBaseUrl {


    @Test
    public void delete01() {


        //1 set the url
        spec.pathParams("first","todos","second",198);

        //send the expected data
        JsonPlaceholderTestData obj=new JsonPlaceholderTestData();
        Map<String,Object> expectedData=obj.expectedDataMethod(21,"Wash the dishes",false);

        //send the Request and GET THE RESPONSE
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).delete("/{first}/{second}");
        response.prettyPrint();
        System.out.println("body"+response.getBody().asString());

        Map<String ,Object> actualData=response.as(HashMap.class);
        assertTrue(actualData.size()==0);

    }


}
