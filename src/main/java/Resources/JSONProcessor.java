package Resources;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONProcessor {

    private ObjectMapper objectMapper;

    public JSONProcessor() {
        this.objectMapper = new ObjectMapper();
    }

    public String objectToJSONString(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            return null;
        }
    }

    public Object jsonToObject(String JSON, Class objClass) {
        try {
            return objectMapper.readValue(JSON, objClass);
        } catch (Exception e) {
            return null;
        }
    }
}
