package com.example.Something.exceptionService.advice;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 전체적으로 exception을 다 잡음
@RestControllerAdvice(basePackages = "com.example.Something.exceptionService") // 특정 패키지의 예외만 잡을수도 있다
public class GlobalControllerAdvice {

    @ExceptionHandler(value = Exception.class)  // 어떤 예외를 잡을 것인지 -> Exception이 발생하면 다 이 메서드로 들어온다
    // rest api 는 responseEntity를 return??
    public ResponseEntity exception(Exception e) {
        // 이 부분을 정의하면 spring boot에서 기본적으로 제공하는 예외 메시지가 대체된다

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
