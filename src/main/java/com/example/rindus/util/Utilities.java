package com.example.rindus.util;

import com.example.rindus.ConsumingRestApplication;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Utilities {

    private static final Logger log = LoggerFactory.getLogger(Utilities.class);


    public static String saveToJson(Object o) {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = null;
        try {
            json = ow.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }


    public static void writeToFile(String filename, String data) {

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(filename + ".json"), StandardCharsets.UTF_8))) {
            writer.write(data);
        } catch (IOException ex) {
            log.error("Error trying to write to file:\n" + data);
        }
    }

//    public static void writeToXML(String jsonData) {
//        JacksonXmlModule module = new JacksonXmlModule();
//        // to default to using "unwrapped" Lists:
//        module.setDefaultUseWrapper(false);
//        XmlMapper xmlMapper = new XmlMapper(module);
//    }


}
