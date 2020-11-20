package cn.lsy99.api.activity.organizer.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ErrorResponseEntityFactory {
    public ResponseEntity<ErrorResponseBody> getResponse(HttpStatus status, String errorCode, String errorMessage) {
        return ResponseEntity.status(status)
                .body(ErrorResponseBody.builder().code(errorCode).message(errorMessage).build());
    }
}
