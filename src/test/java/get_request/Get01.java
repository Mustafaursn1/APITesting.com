package get_request;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Get01 {
    /*
    1.Postman , manuel Api testleri icin kullandik
    2.Otomasyon tetsleri icin de Rest Assured Library kullanacagiz
    3.Otomasyon testleri icin su adimlari izliyoruz
       a)Gereksinimleri anlamak
       b)Test case yaziyoruz
         i)Test Case yaziminda "Gherkin" dilinini kullanacagiz
         Gherkin dilinde kullancagimiz keywordler;
            -Given:On kosullar
            -When:Yapilacak aksiyonlar icin(get(), post() patch() ve delete() )
            -Then:Istek yaptiktan sonra (request gönderdikten sonra )dogrulama icn
            -And:Coklu islemlerde kullanacagiz.

       c)Tets kodlarimizi yazmaya Baslayacagiz

         i) set the URL
         ii) set the expected Data (beklenen datanin olusturulmasi -->post(),put(),patch())
         iii) Type code to send request(Talep gondermek icin kod yazimi)
         iv)Do Assertion(dogrulama yapmak )



Given https://restful-booker.herokuapp.com/booking/101
When User sends a GET Request to the url
Then HTTP Status Code should be 200
And Content Type should be JSON
And Status Line should be HTTP/1.1 200 0K



     */

    @Test
    public void get01() {
        //i) set the URL
        String url = "https://restful-booker.herokuapp.com/booking/541";
        //ii) set the expected Data (beklenen datanin olusturulmasi -->post(),put(),patch())
        //bizden suan bu case de bunlari istemdeigi icin bu meth kullanmiyoruz

        //
        Response response = given().when().get(url);
        response.prettyPrint();

        //iv)Do Assertion(dogrulama yapmak )
        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");

        //Status Line should be HTTP/1.1 200 0K
        System.out.println("Status Code :" + response.statusCode());

        //Content Type konsola yazdir
        System.out.println("Content Type: " + response.contentType());

        //Status Line konsola yazdir
        System.out.println("Status Line : " + response.statusLine());

        // Headers konsola yazdir
        System.out.println("Headers: "+response.getHeaders());



        //Header konsola yazdir
        System.out.println("Header : " + response.getHeader("Server"));


    }


}
