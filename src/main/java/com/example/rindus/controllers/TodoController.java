package com.example.rindus.controllers;

import com.example.rindus.models.Todo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.rindus.ConsumingRestApplication.BASE_URL;
import static com.example.rindus.util.Utilities.TODO_ELEMENT;


@RestController
@RequestMapping("/todos")
public class TodoController {

    private static final Logger log = LoggerFactory.getLogger(TodoController.class);


    @RequestMapping(value = "/getIdFromTitle", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public static String getIdByTitle(@RequestParam(value = "title")String title) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object[]> responseEntity =  restTemplate.getForEntity(String.format("%s%s?title=%s", BASE_URL, TODO_ELEMENT, title), Object[].class);
        Object[] objects = responseEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();
        List<Integer> collect = Arrays.stream(objects)
                .map(object -> mapper.convertValue(object, Todo.class))
                .map(Todo::getId)
                .collect(Collectors.toList());
        if (collect.isEmpty()) {
            return String.format("No found id for title %s", title);
        }
        return String.valueOf(collect.get(0));
    }

}

