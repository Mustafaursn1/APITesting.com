package get_request;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Get08 extends JsonplaceholderBaseUrl {
//Serialozation-->Java objesine   Json formatina dönüstürülmesi-->örnegin jsonPath ile bunu yapabiliyoruz
/*
De-serialization -->Json formantinin Java  objesine  dönüstürülmesi--iki sekilde yapacagiz
1.Gson-->Google tarafindan yapiliyor
2.Object Mapper : Daha popülerdir
*/

// Bu islem API ile iletisim icin gerekli

    /*
    Given
        https://jsonplaceholder.tupicode.com/todos/2
    When
       I send GET Request to the URL
    Then
       Status code is 200
        And  "completed" is false
        And "userId" is 1
        And "title" is "quis ut nam facilis et officia qui"
        And header "Via" is "1.1 vegur"
        And header "Server" is "cloudflare"
       {
        "userId": 1,
        "id": 2,
        "titte": "quis ut nam facilis et officia qui",
         "completed": false
        }

     */

    //1 Set the Url
    //2 Set the expected Data -->put post path
    //3 Send the Request and Get the Response
    //4 Do Assertion

    @Test
    public void get01() {
        //set the Url

        spec.pathParams("first", "todos", "second", 2);

        //2 Set the expected Data==payload -->put post path

        Map<String, Object> expectedData = new HashMap<>();//HashMap() sira gözetmedigi icin en hizli collection
        //!!!!jAVA DA OBJECT FARKLI VERI TIPLERI ILE CALISIRKEN KOLYALIGI VARDIR Fakat Object yavastir ve bircok meth acisindan kisitlidir
        //!!!!Object obj="Bonn"-->String string ="Bonn" olarak kullansak  daha genis bir meth. imkani vardir
        expectedData.put("userId", 1);
        expectedData.put("id", 2);
        expectedData.put("title", "quis ut nam facilis et officia qui");
        expectedData.put("completed", false);
        System.out.println("expectedData: " + expectedData);


        //3 Send the Request and Get the Response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //do Assertion
        //-->body ile karislastirarak yapabiliriz ama burda farkli bir metod kullanacagiz

        Map<String, Object> actualData = response.as(HashMap.class);
        //De-serialisition yaptik & polimorfizm HashMap bir Map gibi hareket edecek bu OOP nin önemli bir özelligi
        System.out.println("actualData: " + actualData);
        //assertEquals(expectedData.get("userId"),(Integer)actualData.get("userId"));
        //assertEquals(expectedData.get("id"),actualData.get("id"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("completed"), actualData.get("completed"));
        assertEquals("1.1 vegur", response.getHeader("Via"));
        assertEquals("cloudflare", response.getHeader("Server"));
        assertEquals(200, response.getStatusCode());


    }


}
