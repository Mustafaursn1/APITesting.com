package testData;

public class PetRestTestData {

    /*
     {
  "id": 0,
  "username": "string",
  "firstName": "string",
  "lastName": "string",
  "email": "string",
  "password": "string",
  "phone": "string",
  "userStatus": 0
}
     */


    public String expectedDataInString(Integer id, String username, String firstname,String lastname, String email,String password,String phone,Integer userStatus) {//dinamik expectedData meth json data to String

        String expectedData = " {\n" +
                "  \"id\": "+id+",\n" +
                "  \"username\": \""+username+"\",\n" +
                "  \"firstName\": \""+firstname+"\",\n" +
                "  \"lastName\": \""+lastname+"\",\n" +
                "  \"email\": \""+email+"\",\n" +
                "  \"password\": \""+password+"\",\n" +
                "  \"phone\": \""+phone+"\",\n" +
                "  \"userStatus\": "+userStatus+"\n" +
                "}";




        return expectedData;
    }




}
