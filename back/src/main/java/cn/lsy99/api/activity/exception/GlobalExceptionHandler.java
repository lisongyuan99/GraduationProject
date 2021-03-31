package cn.lsy99.api.activity.exception;

import cn.lsy99.api.activity.exception.exception.*;
import cn.lsy99.api.activity.response.ErrorResponseBody;
import cn.lsy99.api.activity.response.ErrorResponseEntityFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @Autowired
    ErrorResponseEntityFactory resFactory;

    @ExceptionHandler(value = UsernameAlreadyExistException.class)
    public ResponseEntity<ErrorResponseBody> usernameAlreadyExistExceptionHandler(Exception e) {
        log.warn(e.toString());
        return resFactory.getResponse(HttpStatus.FORBIDDEN,
                "UsernameAlreadyExist",
                "用户名已存在");
    }

    @ExceptionHandler(value = InvalidUsernameException.class)
    public ResponseEntity<ErrorResponseBody> invalidUsernameExceptionHandler(Exception e) {
        log.warn(e.toString());
        return resFactory.getResponse(HttpStatus.FORBIDDEN,
                "InvalidUsername",
                "用户名格式不正确");
    }

    @ExceptionHandler(value = ForbiddenException.class)
    public ResponseEntity<ErrorResponseBody> ForbiddenExceptionExceptionHandler(Exception e) {
        log.warn(e.toString());
        return resFactory.getResponse(HttpStatus.FORBIDDEN,
                "PermissionDenied",
                "无此权限");
    }

    @ExceptionHandler(value = NoTokenException.class)
    public ResponseEntity<ErrorResponseBody> NoTokenExceptionExceptionHandler(Exception e) {
        log.warn(e.toString());
        return resFactory.getResponse(HttpStatus.UNAUTHORIZED,
                "NoToken",
                "需要登录");
    }

    @ExceptionHandler(value = InvalidTokenException.class)
    public ResponseEntity<ErrorResponseBody> InvalidTokenExceptionExceptionHandler(Exception e) {
        log.warn(e.toString());
        return resFactory.getResponse(HttpStatus.FORBIDDEN,
                "InvalidToken",
                "Token不正确");
    }

    @ExceptionHandler(value = TokenExpiredException.class)
    public ResponseEntity<ErrorResponseBody> TokenExpiredExceptionHandler(Exception e) {
        log.warn(e.toString());
        return resFactory.getResponse(HttpStatus.FORBIDDEN,
                "TokenExpired",
                "Token已过期");
    }

    @ExceptionHandler(value = InputFieldException.class)
    public ResponseEntity<ErrorResponseBody> InputFieldExceptionHandler(Exception e) {
        log.warn(e.toString());
        return resFactory.getResponse(HttpStatus.FORBIDDEN,
                "InputFieldWrong",
                "输入字段错误");
    }
}
