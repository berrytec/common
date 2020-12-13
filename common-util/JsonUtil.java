package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 使用jackson的序列化工具类
 */
public class JsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * object -> json
     * @param object
     * @param <T>
     * @return
     */
    public <T> String objectToJson(T object) {
        String jsonString = null;
        try {
            jsonString = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    /**
     * json -> object
     * @param jsonString
     * @param object
     * @param <T>
     * @return
     */
    public <T> Object jsonToObject(String jsonString, T object) {
        try {
            return objectMapper.readValue(jsonString, object.getClass());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
