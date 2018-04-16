package com.zome.lchat.controller;

import com.zome.lchat.utils.JsonMessage;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.xml.validation.Validator;
import java.math.BigDecimal;

public class BaseController {





    @ExceptionHandler(RuntimeException.class)
    public
    @ResponseBody
    Object exp(Exception e) {
        e.printStackTrace();
        return JsonMessage.UNKNOWN_ERROR;
    }
}
