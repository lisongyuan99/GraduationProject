package cn.lsy99.api.activity.organizer.auth;

import cn.lsy99.api.activity.organizer.auth.exception.InvalidUsernameException;
import cn.lsy99.api.activity.organizer.auth.exception.UsernameAlreadyExistException;
import cn.lsy99.api.activity.organizer.error.ErrorResponseBody;
import cn.lsy99.api.activity.organizer.error.ErrorResponseEntityFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class AuthExceptionHandler {

    @Autowired
    ErrorResponseEntityFactory resFactory;

//    @ExceptionHandler(value = BadCredentialsException.class)
//    public ResponseEntity<ErrorResponseBody> badCredentialsExceptionHandler(Exception e) {
//        log.warn(e.toString());
//        return resFactory.getResponse(HttpStatus.UNAUTHORIZED,
//                "WrongUsernameOrPassword",
//                "用户名或密码错误");
//    }
//
//    @ExceptionHandler(value = AuthenticationException.class)
//    public ResponseEntity<ErrorResponseBody> authenticationExceptionHandler(Exception e) {
//        log.warn(e.toString());
//        return resFactory.getResponse(HttpStatus.UNAUTHORIZED,
//                "AccountError",
//                "账户异常");
//    }

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

}
