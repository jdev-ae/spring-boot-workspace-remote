package com.suru.springboot.testerrors.controllers;

import com.suru.springboot.testerrors.exceptions.MyNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SampleController {

    @RequestMapping("/page")
    public String showMyPage() {
        return "mypage";
    }

    @RequestMapping("/post/{data}")
    public String postMyData(Model model, @PathVariable("data") String data) throws MyNotFoundException {
        model.addAttribute("data", data);
        throw new MyNotFoundException("data not found!!!!");
//        return "show-data";
    }

    @ExceptionHandler(MyNotFoundException.class)
    public String myExceptionHandler(Model model, HttpServletRequest request, MyNotFoundException e) {
        model.addAttribute("exception", e);
        return "my-not-found-exception";
    }

}
