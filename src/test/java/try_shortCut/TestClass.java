package try_shortCut;

import java.util.Map;

public class TestClass {
    public static void main(String[] args) {


        AsserShortCut obj=new AsserShortCut();
        Map<String,Object> expectedData=obj.expectedData(2,"BEN BIR METH OLUSTURDUM",false);
        Map<String,Object> actualData=obj.expectedData(4,"BEN BIR METH OLUSTURDUM2",true);


        obj.isMapEquals(expectedData,actualData);






    }
}
