package com.example.rindus.controllers;


import com.example.rindus.models.Comment;
import com.example.rindus.util.Format;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;



import static com.example.rindus.ConsumingRestApplication.BASE_URL;
import static com.example.rindus.util.Utilities.*;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private static final Logger log = LoggerFactory.getLogger(CommentController.class);



    @RequestMapping(value = "/getById", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public static String getComment(@RequestParam(value = "id") String id) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            Comment comment = restTemplate.getForObject(String.format("%s%s%s", BASE_URL, COMMENT_ELEMENT, id), Comment.class);

            String json = serialize(comment, Format.JSON);

            String xmlString = serialize(comment, Format.XML);
            writeToFile(String.format("commentById=%s", id), xmlString);

            return json;
        } catch (HttpClientErrorException e) {
            return String.format("Error trying to GET comment with id = %s", id);
        }
    }

    @RequestMapping(value = "/deleteById", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public static String deleteComment(@RequestParam(value = "id")Integer id){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(BASE_URL+ COMMENT_ELEMENT +id);
        return String.format("Entry deleted for comment with id=%d", id);
    }

    public static void postComment(Comment comment){

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Comment> request = new HttpEntity<>(comment);
        Comment foo = restTemplate.postForObject(BASE_URL+COMMENT_ELEMENT, request, Comment.class);
        log.info("Comment posted");


    }
}
