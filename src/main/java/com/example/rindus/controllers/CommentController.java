package com.example.rindus.controllers;


import com.example.rindus.models.Comment;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static com.example.rindus.ConsumingRestApplication.BASE_URL;
import static com.example.rindus.ConsumingRestApplication.commentElement;
import static com.example.rindus.util.Utilities.saveToJson;
import static com.example.rindus.util.Utilities.writeToFile;

@RestController
//@RequestMapping("/comments")
public class CommentController {

    private static final Logger log = LoggerFactory.getLogger(CommentController.class);

//    @RequestMapping(value = "/fetchjson", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public static void getComment(@PathVariable("i") String i, String filename) {
//        RestTemplate restTemplate = new RestTemplate();
//        Comment comment = restTemplate.getForObject(BASE_URL + commentElement + i, Comment.class);
//
//        System.out.println("ok");
//        String json = null;
//
//        json = saveToJson(comment);
//        System.out.println("json is " + json + ".end");
//        writeToFile(filename, json);
//    }

    @RequestMapping(value = "/comments", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public static String getComment(@RequestParam(value = "id", defaultValue = "7") String id) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            Comment comment = restTemplate.getForObject(BASE_URL + commentElement + id, Comment.class);

            System.out.println("ok");
            String json = null;

            json = saveToJson(comment);
            System.out.println("json is " + json + ".end");
            writeToFile("commentById="+id, json);

            return json;
        } catch (HttpClientErrorException e) {
            return "Error trying to GET comment with id = "+id;
        }

    }




//    @RequestMapping(value = "/fetchjson/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Comment getForObjectJsonDemo(@PathVariable(value = "id") Integer id) {
//        return new Comment();
//
//    }
//
//    @RequestMapping(value = "/ex/foos", method = RequestMethod.GET)
//    @ResponseBody
//    public String getFoosBySimplePath() {
//        return "Get some Foos";
//    }
//
//    @RequestMapping(value = "/ex/foos/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public static String getFoosBySimplePathWithPathVariable(
//            @PathVariable("id") long id) {
//        RestTemplate restTemplate = new RestTemplate();
//        Comment comment = restTemplate.getForObject(BASE_URL + commentElement + "5", Comment.class);
//        return comment.toString();
//    }
}
