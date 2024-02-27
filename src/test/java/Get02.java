import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static junit.framework.TestCase.*;

public class Get02 {

    /*
    Given https://restful-booker.herokuapp.com/booking/1
    Then User send a GET Request to the Url

    And HTTP Status Code should be 404
    And Status Line should be HTTP/1.1 404 Not Found
    And Response body contains "Not Found"
    And Redponse body doesn't contain "Zalando"
    And Server is "Cowboy"
    */

    @Test
    public void get01() {
        //i)set the Url
        String url = "https://restful-booker.herokuapp.com/booking/2";
        //ii) set the expected Data (beklenen datanin olusturulmasi -->post(),put(),patch())
        //bizden suan bu case de bunlari istemdeigi icin bu meth kullanmiyoruz

        //iii) Type code to send request(Talep gondermek icin kod yazimi)
        Response response = given().when().get(url);
        response.prettyPrint();
        //iv Do Assertion (dogrulama)
        System.out.println("status code: " + response.statusCode());

        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");

        String contain = response.asString();
        System.out.println("contain: " + contain);
        //Body Not Found iceriyor mu
        Assert.assertTrue(contain.contains("Not Found"));
        //Body Zalando iceriyor mu
        assertFalse(response.asString().contains("Zalando"));
        //Server Cowboy mu?
        assertEquals("Cowboy",response.getHeader("Server"));


    }


}
