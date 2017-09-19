package com.suru.stopatstart.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController implements ErrorController {

    @RequestMapping("/error")
    public String showError(Model model) {
        model.addAttribute("error", "some error");
        model.addAttribute("message", "some message");
        return "myErrorPage";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
