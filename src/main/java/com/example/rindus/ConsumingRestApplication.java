package com.example.rindus;


import com.example.rindus.models.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import static com.example.rindus.controllers.CommentController.*;
import static com.example.rindus.controllers.TodoController.getIdByTitle;


@SpringBootApplication
public class ConsumingRestApplication {

    private static final Logger log = LoggerFactory.getLogger(ConsumingRestApplication.class);

    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";


    public static void main(String[] args) {


        SpringApplication.run(ConsumingRestApplication.class, args);

        //Get the comment with id=5
        getComment("5");

        //Delete comment with id=4
        deleteComment(4);

        //Get the id of the "TODOS" element with title = "et doloremque nulla"
        getIdByTitle("et doloremque nulla");

        //Post new comment
        Comment comment = new Comment(12345, 23456, "newName", "abc@mail.com", "newBody");
        postComment(comment);

    }
}
