package cn.lsy99.api.file.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorResponseBody {
    @Builder.Default
    String code = "";
    @Builder.Default
    String message = "";

    public String toJsonString(){
        String reult = "";
        try {
            reult = new ObjectMapper().writeValueAsString(
                    ErrorResponseBody.builder().code(code).message(message).build());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return reult;
    }
}
