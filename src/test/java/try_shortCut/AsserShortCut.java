package try_shortCut;

import java.util.HashMap;
import java.util.Map;

public class AsserShortCut {

    public Map<String, Object> expectedData(Integer userId, String title, Boolean completed) {
        Map<String, Object> expectedDataMap = new HashMap<>();

        expectedDataMap.put("userId", userId);
        expectedDataMap.put("title", title);
        expectedDataMap.put("comleted", completed);

        return expectedDataMap;

    }


    public Boolean isMapEquals(Map<String, Object> map1, Map<String, Object> map2) {
        Map<String, Object> map_1 = new HashMap<>();
        Map<String, Object> map_2 = new HashMap<>();


        for (int i = 0; i <= map_1.size(); i++) {

            for (int k = 0; k <= map_2.size(); k++) {
                if (map_1.get(i) == map_2.get(k)) System.out.println("iki map birbirine esittir");
                else {
                    System.out.println("iki map esit degil");
                }


            }
        }


        return null;
    }


}
