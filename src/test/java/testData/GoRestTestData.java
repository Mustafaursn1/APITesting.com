package testData;

import java.util.HashMap;
import java.util.Map;

public class GoRestTestData {

    /*
    {
    "meta": null,
    "data": {
        "id": 6752686,
        "name": "Bhardwaj Deshpande",
        "email": "bhardwaj_deshpande@mueller.example",
        "gender": "male",
        "status": "active"
    }
}
     */


    public Map<String, String> dataKeyMap(String name, String email, String gender, String status) {

        Map<String, String> dataKeyMap = new HashMap<>();
        dataKeyMap.put("name", name);
        dataKeyMap.put("email", email);
        dataKeyMap.put("gender", gender);
        dataKeyMap.put("status", status);


        return dataKeyMap;
    }

    public Map<String, Object> expectedDataMeth(Object meta, Map<String, String> data) {
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("meta", meta);
        expectedData.put("data", data);

        return expectedData;
    }


}
