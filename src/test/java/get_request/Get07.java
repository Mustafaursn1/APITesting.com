package get_request;

import base_url.JsonPlaceholderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get07 extends JsonPlaceholderBaseUrl {
    /*
    Given
        https://isonplaceholder.tupicode.com/todos
    When
       I send GET Request to the URL == › URL'e Get Request gonderin
    Then
      1)Status code is 200 == › Status kodu 200 olmali
      2)Print all ids greater than 190 on the console ==› id si 190 dan buyuk olanlari konsola yazdir
        Assert that there are 10 ids greater than 190 == > 10 tane id nin 190 dan buyuk oldugunu dogrulayin
      3)Print all userIds whose ids are less than 5 on the console ==>
       id si 5 den kucuk olan tum userid lerini konsolunu yazdirin
       Assert that the number of userids whose ids are less than 5 is 4 ==>
       id si 5 den kucuk olan 4 tane userId oldugunu dogrutayin
      4)Print all titles whose ids are less than 5 ==> id si 5 den kucuk olan tum basliklari yazdirin
        Assert that "delectus aut autem" is one of the titles whose id is less than 5 ==> id si 5 den
        kucuk olan datalarin birinin basliginin "delectus aut autem" icerdigini dogrulayin
     */
    @Test
    public void get01() {
        //1 set the Url
        spec.pathParam("first", "todos");

        // 2 Send the Expected DATA (put ,patch ,post)-->now is any request

        //3 Send The Request And Get the Response
        Response response = given().spec(spec).when().get("/{first}");
        //response.prettyPrint();

        //4 Do Asserttion

        //1)Status code is 200 == › Status kodu 200 olmali
        response.then().assertThat().statusCode(200);
        //assertEquals(200,response.getStatusCode());


        //2)Print all ids greater than 190 on the console
        JsonPath json = response.jsonPath();
        List<Integer> ids = json.getList("findAll{it.id>190}.id");//Groovy Language -->java temelli programlama dili
        System.out.println("Id si 190 dan büyük olanlar:" + ids);

        //Assert that there are 10 ids greater than 190
        assertEquals("Id 190 dan büyük olan eslesmedi", 10f, ids.size());


        //3)Print all userIds whose ids are less than 5 on the console
        List<Integer> userIdLessThan5 = json.getList("findAll{it.id<5}.userId");
        System.out.println("Id si 5 ten kücük olan UserId" + userIdLessThan5);


        //Assert that the number of userids whose ids are less than 5 is 4
        assertEquals("Id si 5 ten kücük olan userId ler 4 tane degil",4,userIdLessThan5.size());


        //4)Print all titles whose ids are less than 5
        List<String> titles=json.getList("findAll{it.id<5}.title");
        System.out.println("Id si 5 ten kücük olan  titles:"+titles);

        //Assert that "delectus aut autem" is one of the titles whose id is less than 5
        assertTrue("Id si 5 ten Kücük olan Titlerden herhangi biri  delectus aut autem icermemektedir ",
                titles.stream().anyMatch(t->t.equals("delectus aut autem")));
        assertTrue("Id si 5 ten Kücük olan Titlerden herhangi biri  delectus aut autem icermemektedir ",
                titles.contains("delectus aut autem"));


    }


}
