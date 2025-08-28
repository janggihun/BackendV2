package com.bismo.stellive.api.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@Slf4j
@RestControllerAdvice
public class ExceptionHandler {


    //유효성 검사
    @org.springframework.web.bind.annotation.ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonResponse<String> throwException(MethodArgumentNotValidException e) {
        log.info(e.getMessage());
        log.info("여기");
        String errorMessage = e.getBindingResult().getFieldErrors().stream()
                .findFirst()
                .map(fieldError -> fieldError.getDefaultMessage())
                .orElse("유효성 검사 실패");


        return CommonResponse.error(errorMessage);
    }

    //jackson에서 문제 생김
    @org.springframework.web.bind.annotation.ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonResponse<String> throwException(HttpMessageNotReadableException e) {

        return CommonResponse.error("유효성 검사 실패");
    }

    //db연결시 문제생김
    @org.springframework.web.bind.annotation.ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonResponse<String> throwException(SQLIntegrityConstraintViolationException e) {

        return CommonResponse.error("데이터베이스 오류");
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonResponse<String> throwException(IllegalArgumentException e) {
        log.info("e : {}", e);
        return CommonResponse.error(e.getMessage());
    }

    //비밀번호 다른 경우
//    @org.springframework.web.bind.annotation.ExceptionHandler
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public CommonResponse<String> throwException(BadCredentialsException e){
//        log.error("BadCredentialsException={}", e);
//        // 첫 번째 필드 에러 메시지 추출
//        String errorMessage = e.getMessage();
//
//        return CommonResponse.error(errorMessage);
//    }


}
