package com.example.rindus;

import com.example.rindus.models.Comment;
import com.example.rindus.models.Todo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;



import static com.example.rindus.controllers.CommentController.getComment;
import static com.example.rindus.util.Utilities.saveToJson;
import static com.example.rindus.util.Utilities.writeToFile;


@SpringBootApplication
public class ConsumingRestApplication {

    private static final Logger log = LoggerFactory.getLogger(ConsumingRestApplication.class);

    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    public static final String commentElement = "comments/";
    public static final String todoElement = "todo/";
    public static final String userElement = "user/";

    public static void main(String[] args) {


        SpringApplication.run(ConsumingRestApplication.class, args);

        //Get the comment with ID=5
        getComment("5");


        //Get the

        //Delete x


        //Push Y


        try {
            // metodoDeMierda("6");
        } catch (Exception e) {
            e.printStackTrace();
        }
//
//        Todo todo = restTemplate.getForObject(
//                "https://jsonplaceholder.typicode.com/todos/" + 6, Todo.class);
//
//        String jsonData = storeAsJson(todo.toString());
//        log.info("jsonData:\n" + jsonData);
//
//
//        writeToFile("jsonFile", jsonData);
//
//        Todo todo2 = restTemplate.getForObject(
//                "https://jsonplaceholder.typicode.com/todos/{id}", Todo.class, 6);
//
//        String jsonData2 = storeAsJson(todo2.toString());
//        writeToFile("jsonFile2", jsonData2);


    }



//    private static void getElement(String commentElement, Object o, String i) {
//        RestTemplate restTemplate = new RestTemplate();
//        if (o instanceof Comment) {
//            o = (Comment) o;
//        }
//        Comment comment = restTemplate.getForObject(BASE_URL + commentElement + i, Comment.class);
//
//        String json = saveToJson(comment);
//
//
//        writeToFile("tpmns3rdwfdwefta", json);


//        System.out.println(BASE_URL+commentElement+i);
//        System.out.println("https://jsonplaceholder.typicode.com/comments/"+i);
        //Comment Comment = restTemplate.getForObject("https://jsonplaceholder.typicode.com/comments/"+i, Comment.class);
//    }

//    private static String saveToJson(Object o) {
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        String json = null;
//        try {
//            json = ow.writeValueAsString(o);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        return  json;
//    }

//    private static void metodoDeMierda(String id) throws Exception {
//
//        RestTemplate restTemplate = new RestTemplate();
//
//        Todo todo = restTemplate.getForObject(
//                "https://jsonplaceholder.typicode.com/todos/" + id, Todo.class);
//
//
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        String json = ow.writeValueAsString(todo);
//
//        log.info("2222\n" + json);
//        writeToFile("probaasadzxcdfdeddddddddddddndo1", json);
//
//    }


//    private static String parseToJson(String data) throws JsonProcessingException {
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        return ow.writeValueAsString(data);
//    }
//
//    private static String storeAsJson(String data) {
//        String json = "";
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        try {
//            json = ow.writeValueAsString(data);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        return json;
//    }

//    private static void writeToFile(String filename, String data) {
//
//        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
//                new FileOutputStream(filename + ".json"), StandardCharsets.UTF_8))) {
//            writer.write(data);
//        } catch (IOException ex) {
//            LOG.error("Error trying to write file:\n"+data);
//        }
//        /*ignore*/
//    }


//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder builder) {
//        return builder.build();
//    }

//    @Bean
//    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
//        return args -> {
//            int id = 5;
//            Todo todo = restTemplate.getForObject(
//                    "https://jsonplaceholder.typicode.com/todos/" + id, Todo.class);
//            //log.info("1\n"+todo.toString());
//
//
//            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//            String json = ow.writeValueAsString(todo);
//
//            log.info("2\n" + json);

//            JSONObject jsonObject = new JSONObject(json);
//            String xml = XML.toString(jsonObject);
//            //log.info("3\n"+xml);
//
//            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
//                    new FileOutputStream("filename.xml"), "utf-8"))) {
//                writer.write(xml);
//            }
    //  };
    //  }
}
