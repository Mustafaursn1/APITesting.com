package testData;

import java.util.HashMap;
import java.util.Map;

public class ResfullTestData {

    /*
     {
       "firstname"：“John"，
        "Lastname": "Doe"
        "totalprice": 11111,
        "depositpaid": true,
        "bookingdates": {
        "checkin": "2021-09-09",
        "checkout"： "2021-09-21"
         }
      }

     */

    public Map<String,String> innerData(String checkin,String checkout ){
        Map<String,String>  bookingData=new HashMap<>();
        bookingData.put("checkin",checkin);
        bookingData.put("checkout",checkout);





       return  bookingData;
    }

    public Map<String ,Object> expectedDataMeth(String firstName,String lastName,int totalPrice,Boolean depositPaid,Map<String,String> bookingDate){
        Map<String,Object> expectedData=new HashMap<>();
        expectedData.put("firstname",firstName);
        expectedData.put("lastname",lastName);
        expectedData.put("totalprice",totalPrice);
        expectedData.put("depositpaid",depositPaid);
        expectedData.put("bookingdates",bookingDate);


    return expectedData;
    }



}
