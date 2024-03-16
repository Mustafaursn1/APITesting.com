package get_request;

import base_url.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.annotations.AfterTest;
import pojo.DummyRestApiDataPojo;
import pojo.DummyRestApiResponseBodyPojo;
import utilities.ObjectMapperUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class Get16 extends DummyRestApiBaseUrl {
    /*

    URL: https://dummy.restopiexample.com/api/v1/employees
    HTTP Request Method: GET Request
    Test Case: Type by using Gherkin Language

    Assert:
          i) Status code is 200
          ii) There are 24 employees
          iii) "Tiger Nixon" and "Garrett Winters" are among the employees iv) The greatest oge is óó
           v) The name of the lowest age is "Totyona Fitzpatrick"
           vi) Total salary of all employees is 6,644,770

     */

    /*
     Test Case
    Given
          https://dummy.restopiexample.com/api/v1/employees
    When
         User sends Get Request
    Then
         Status code is 200
    And
        There are 24 employees
    And
        "Tiger Nixon" and "Garrett Winters" are among the employees
    And
           The greatest oge is 66
    And
         The name of the lowest age is "Tatyana Fitzpatrick"
    And
        Total salary of all employees is 6,644,770

     */

    @Test
    public void get01(){
         // 1 set the Url
      spec.pathParam("first","employees") ;
         //2 set the expected Data

        //3 Send the Get Request and Get the Response
        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();


        //4 Do Assertions
        //DummyRestApiResponseBodyPojo actualData= ObjectMapperUtils.convertJsonToJava(response.asString(),DummyRestApiResponseBodyPojo.class);
       // System.out.println("actualData: "+actualData);
        assertEquals(200,response.statusCode());
        response.then().assertThat().body("data.id",hasSize(24),"data.employee_name",hasItems("Tiger Nixon","Garrett Winters"));
        List<Integer> ages=response.jsonPath().getList("data.employee_age");
        System.out.println("ages: "+ages);
        Collections.sort(ages);
        System.out.println("sorted Ages: "+ages);
        System.out.println(ages.get(ages.size()-1));

        assertEquals(66,(int)(ages.get(ages.size()-1)));



        String lowestAgedEmployeeName=response.jsonPath().getString("data.findAll{it.employee_age=="+ages.get(0)+"}.employee_name");
        System.out.println("Yasi kücük olan kisi: "+lowestAgedEmployeeName);
        String expectedLowerName="[Tatyana Fitzpatrick]";
        assertEquals(expectedLowerName,lowestAgedEmployeeName);

        List<Integer> salaries=response.jsonPath().getList("data.employee_salary");
        System.out.println("Salaries of Employee:"+salaries);

        //1.yol
        int sum=0;
        for (int w:salaries) {
            sum+=w;
        }
        System.out.println("toplam maas: "+sum);
        assertEquals(6644770,sum);

        //2.yol
       int sum2= salaries.stream().reduce(0,(t,u)->t+u);
        System.out.println(sum2);

        int sum3=salaries.stream().reduce(0,Math::addExact);
        System.out.println(sum3);
        int sum4 =salaries.stream().reduce(0,Integer::sum);
        System.out.println("sum4: "+sum4);

        int sum5=0;
        int caunt=0;
        for (int i = 0; i < salaries.size(); i++) {
            sum5+=salaries.get(i);
            caunt++;



        }
        System.out.println("sum5:"+sum5);
        System.out.println("count: "+caunt);









    }


    @Test
    public void test01(){

        List<Integer> say=new ArrayList<>();
        say.add(10);
        say.add(20);
        say.add(123);
        say.add(2534);




        say.stream().forEach(t->System.out.println(t));
        int toplam=say.stream().reduce(1,(t,u)->t*u);
        System.out.println("toplam:"+toplam);
        System.out.println("carpim_"+10*20*123*2534);



    }



}
