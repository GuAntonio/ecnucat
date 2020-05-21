package com.example.libraryse.exception;

import com.example.libraryse.result.Result;
import com.example.libraryse.result.ResultFactory;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler {

        @ExceptionHandler(value = Exception.class)
        public Result exceptionHandler(Exception e) {
            String message = null;

            if (e instanceof IllegalArgumentException) {
                message = "传入了错误的参数";
            }

            if (e instanceof MethodArgumentNotValidException) {
                message = ((MethodArgumentNotValidException) e).getBindingResult().getFieldError().getDefaultMessage();
            }

            if (e instanceof UnauthorizedException) {
                message = "权限认证失败";
            }

            return ResultFactory.buildFailResult(message);
        }
    }