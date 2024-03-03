package testData;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceholderTestData {

    //variable static yaparsak baska class larda yapilan degisiklikler mevcut variable etkiler.
    //cok spesifik bir ihtiyac olmadikca class dan object olusturmak daha iyi bir secenektir

    public Map<String, Object> expectedData(Integer userId,String title,Boolean completed) {

        Map<String, Object> expectedData = new HashMap<>();//HashMap() sira gözetmedigi icin en hizli collection
        //!!!!jAVA DA OBJECT FARKLI VERI TIPLERI ILE CALISIRKEN KOLYALIGI VARDIR Fakat Object yavastir ve bircok meth acisindan kisitlidir
        //!!!!Object obj="Bonn"-->String string ="Bonn" olarak kullansak  daha genis bir meth. imkani vardir
        expectedData.put("userId", 1);
        expectedData.put("title", "quis ut nam facilis et officia qui");
        expectedData.put("completed", false);
        //Boolean default degeri null iken boolean defaul degeri false


        return expectedData;
    }

}
