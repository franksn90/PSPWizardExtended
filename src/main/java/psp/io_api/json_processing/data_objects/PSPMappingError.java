package psp.io_api.json_processing.data_objects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class PSPMappingError implements PSPMappingResponse {
    private final String TYPE = "mapping_error";
    private final Map<String, String> payload;

    public PSPMappingError(String error){
        this.payload = new HashMap<>();
        payload.put("error", error);
    }

    public Map<String, String> getPayload() {
        return payload;
    }

    public String getType() {
        return TYPE;
    }

    @Override
    public String toJSON() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(this);
    }
}
