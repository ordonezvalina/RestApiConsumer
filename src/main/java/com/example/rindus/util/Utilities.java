package com.example.rindus.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Utilities {

    private static final Logger log = LoggerFactory.getLogger(Utilities.class);
    public static final String COMMENT_ELEMENT = "comments/";
    public static final String TODO_ELEMENT = "todos/";

    private static final ObjectMapper XML_MAPPER = new XmlMapper().enable(SerializationFeature.INDENT_OUTPUT);
    private static final ObjectMapper JSON_MAPPER = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);


    public static String serialize(Object article, Format format) {
        return format.equals(Format.XML) ? serialize(article, XML_MAPPER) : serialize(article, JSON_MAPPER);
    }

    public static String serialize(Object o, ObjectMapper objectMapper) {
        try {
            return objectMapper.writeValueAsString(o);
        } catch (IOException e) {
            throw new UncheckedIOException("Error trying to serialize", e);
        }
    }

    public static void writeToFile(String filename, String data) {

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(filename + ".xml"), StandardCharsets.UTF_8))) {
            writer.write(data);
        } catch (IOException ex) {
            log.error("Error trying to write to file:\n" + data);
        }
    }

}
