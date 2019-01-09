package com.demo.exception;

import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 异常处理
 */
//@ControllerAdvice
public class MyExceptionHanlder {
    private Logger logger = LoggerFactory.getLogger(MyExceptionHanlder.class);
    @ExceptionHandler(value = {IncorrectCredentialsException.class,
            AuthorizationException.class,AuthorizationException.class, ShiroException.class})
    public void authenticationAndAuthoricationExcecptionHand(){
        logger.info("exception");
    }
}
