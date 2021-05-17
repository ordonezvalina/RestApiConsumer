package com.example.rindus.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TodoController {

    private static final Logger log = LoggerFactory.getLogger(TodoController.class);


    @GetMapping("/testing")
    public String cacas(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hi I'm "+name+" and Im testing";
    }



}

