package com.suru.stopatstart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

//@Controller
public class CustomErrorController implements ErrorController {

    private static final String ERROR_PATH = "/error";
    private static final String ERROR_TEMPLATE = "myErrorPage";
    private final ErrorAttributes errorAttributes;


    @Autowired
    public CustomErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }


    @RequestMapping(ERROR_PATH)
    public String error(Model model, HttpServletRequest request) {
//        Map<String, Object> errorAttributes = getErrorAttributes(request, true);
//        model.addAttribute("timestamp", errorAttributes.get("timestamp"));
//        model.addAttribute("status", errorAttributes.get("status"));
//        model.addAttribute("error", errorAttributes.get("error"));
//        model.addAttribute("message", errorAttributes.get("message"));
//        model.addAttribute("path", errorAttributes.get("path"));
        return ERROR_TEMPLATE;
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }


    private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
        ServletRequestAttributes requestAttributes = new ServletRequestAttributes(request);
        return this.errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
    }
}
