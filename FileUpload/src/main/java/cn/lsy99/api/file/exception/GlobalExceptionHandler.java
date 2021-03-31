package cn.lsy99.api.file.exception;

import cn.lsy99.api.file.exception.exception.FileErrorException;
import cn.lsy99.api.file.exception.exception.InvalidTokenException;
import cn.lsy99.api.file.exception.exception.NoTokenException;
import cn.lsy99.api.file.exception.exception.TokenExpiredException;
import cn.lsy99.api.file.response.ErrorResponseBody;
import cn.lsy99.api.file.response.ErrorResponseEntityFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartException;


@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @Autowired
    ErrorResponseEntityFactory resFactory;

    @ExceptionHandler(value = NoTokenException.class)
    public ResponseEntity<ErrorResponseBody> NoTokenExceptionExceptionHandler(Exception e) {
        log.info(e.toString());
        return resFactory.getResponse(HttpStatus.UNAUTHORIZED,
                "NoToken",
                "需要登录");
    }

    @ExceptionHandler(value = InvalidTokenException.class)
    public ResponseEntity<ErrorResponseBody> InvalidTokenExceptionExceptionHandler(Exception e) {
        log.info(e.toString());
        return resFactory.getResponse(HttpStatus.FORBIDDEN,
                "InvalidToken",
                "Token不正确");
    }

    @ExceptionHandler(value = TokenExpiredException.class)
    public ResponseEntity<ErrorResponseBody> TokenExpiredExceptionExceptionHandler(Exception e) {
        log.info(e.toString());
        return resFactory.getResponse(HttpStatus.FORBIDDEN,
                "TokenExpired",
                "Token已过期");
    }

    @ExceptionHandler(value = FileErrorException.class)
    public ResponseEntity<ErrorResponseBody> FileErrorExceptionHandler(Exception e) {
        log.info(e.toString());
        return resFactory.getResponse(HttpStatus.SERVICE_UNAVAILABLE,
                "FileError",
                "服务器文件发生错误");
    }

    @ExceptionHandler(MultipartException.class)
    @ResponseStatus(value = HttpStatus.PAYLOAD_TOO_LARGE)
    public ResponseEntity<ErrorResponseBody> FileTooBigHandler(Exception e) {
        log.info(e.toString());
        return resFactory.getResponse(HttpStatus.FORBIDDEN,
                "FileTooBig",
                "文件过大");
    }
}
