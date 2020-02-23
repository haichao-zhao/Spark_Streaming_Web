package com.zhc.spark.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloBoot {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        return "hello world Spring Boot...";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ModelAndView testEcharts() {
        return new ModelAndView("test");
    }

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public ModelAndView demo() {
        return new ModelAndView("demo");
    }

}
