package utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtils {

    //Map<String, Object> expectedData = new ObjectMapper().readValue(jsonInString, HashMap.class);
    private static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();

    }

    public static <T> T convertJsonToJava(String json,Class<T> cls){//Generic Meth
        T javaResult=null;


        try {
            javaResult=mapper.readValue(json,cls);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        return javaResult;

    }

}
