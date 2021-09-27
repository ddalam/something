package com.example.Something.exceptionService.controller;

import com.example.Something.exceptionService.dto.ExceptionServiceUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class RestApiController {

    @GetMapping("")
    public ExceptionServiceUser get(@RequestParam(required = false) String name, @RequestParam(required = false) Integer age) {
        ExceptionServiceUser exceptionServiceUser = ExceptionServiceUser.builder()
                .name(name)
                .age(age)
                .build();

        int a = 10 + age;   // null point exception 발생 시키기

        return exceptionServiceUser;
    }

    @PostMapping("")
    public ExceptionServiceUser post(@Valid @RequestBody ExceptionServiceUser exceptionServiceUser) {
        return exceptionServiceUser;
    }

    // 이 ExceptionHandler는 이 컨트롤러 안에서 일어난 예외에만 관여한다
    // global exception handler에 동일한 내용이 있더라도 이게 우선순위가 높다
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
