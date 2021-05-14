package com.example.rindus;

import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

@SpringBootApplication
public class ConsumingRestApplication {

    private static final Logger log = LoggerFactory.getLogger(ConsumingRestApplication.class);

    public static void main(String[] args) {
        System.out.println("Amigo de Vigo de Bigote");
        SpringApplication.run(ConsumingRestApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Todo todo = restTemplate.getForObject(
                    "https://jsonplaceholder.typicode.com/todos/2", Todo.class);
            log.info(todo.toString());

            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(todo);
            log.info(json.toString());

            JSONObject jsonObject = new JSONObject(json);
            String xml = XML.toString(jsonObject);
            log.info(xml);

            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("filename.xml"), "utf-8"))) {
                writer.write(xml);
            }
        };
    }
}
