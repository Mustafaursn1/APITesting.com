package testData;



import java.util.HashMap;
import java.util.Map;

public class JsonPlaceholderTestData {

    //variable static yaparsak baska class larda yapilan degisiklikler mevcut variable etkiler.
    //cok spesifik bir ihtiyac olmadikca class dan object olusturmak daha iyi bir secenektir

    public Map<String, Object> expectedDataMethod(Integer userId, String title, Boolean completed) {

        Map<String, Object> expectedDataMap = new HashMap<>();//HashMap() sira gözetmedigi icin en hizli collection
        //!!!!jAVA DA OBJECT FARKLI VERI TIPLERI ILE CALISIRKEN KOLYALIGI VARDIR Fakat Object yavastir ve bircok meth acisindan kisitlidir
        //!!!!Object obj="Bonn"-->String string ="Bonn" olarak kullansak  daha genis bir meth. imkani vardir
        if (userId != null) {
            expectedDataMap.put("userId", userId);

        }
        if (title != null) {

            expectedDataMap.put("title", title);
        }
        if (completed != null) {
            expectedDataMap.put("completed", completed);
            //Boolean default degeri null iken boolean defaul degeri false
        }


        return expectedDataMap;
    }


    public String expectedDataInString(int userId, String title, boolean completed) {//dinamik expectedData meth json data to String

        String expectedData = "{\n" +
                "    \"userId\": " + userId + ",\n" +
                "    \"title\": \"" + title + "\",\n" +
                "    \"completed\": " + completed + "\n" +
                "   }";

        return expectedData;
    }

}
