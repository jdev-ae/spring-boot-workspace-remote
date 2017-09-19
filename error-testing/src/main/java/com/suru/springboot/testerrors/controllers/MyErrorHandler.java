package com.suru.springboot.testerrors.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class MyErrorHandler implements ErrorController {

    private final ErrorAttributes errorAttributes;

    @Autowired
    public MyErrorHandler(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    private Map<String, Object> getErrorMap(HttpServletRequest request) {
        ServletRequestAttributes requestAttributes = new ServletRequestAttributes(request);
        return this.errorAttributes.getErrorAttributes(requestAttributes, true);
    }

    @RequestMapping("/error")
    public String showError(Model model, HttpServletRequest request) {
        Map<String, Object> errorAttributes = getErrorMap(request);
        model.addAttribute("timestamp", errorAttributes.get("timestamp"));
        model.addAttribute("status", errorAttributes.get("status"));
        model.addAttribute("error", errorAttributes.get("error"));
        model.addAttribute("message", errorAttributes.get("message"));
        model.addAttribute("path", errorAttributes.get("path"));
        return "custom-error";
    }


    @RequestMapping("/404")
    public String custom404Error(Model model, HttpServletRequest request) {
        model.addAttribute("error", getErrorMap(request));
        return "404-custom-page";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
