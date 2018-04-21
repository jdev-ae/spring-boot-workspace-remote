package com.suru.springbootswagger.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/calc")
public class CalculatorController {

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public double add(@RequestParam("number1") double number1, @RequestParam("number2") double number2) {
        return number1 + number2;
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public double add(@RequestBody List<Double> numbers) {
        return numbers.stream().reduce(0.0, Double::sum);
    }
}
