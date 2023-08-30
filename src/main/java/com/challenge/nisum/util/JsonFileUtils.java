package com.challenge.nisum.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonFileUtils {
    private static ObjectMapper OBJECT_MAPPER;

    private JsonFileUtils() {}

    /**
     * Helper method to read file from classpath
     *
     * @param pathFilename path from classpath
     * @return String with file content
     */
    public static String readFileFromClasspath(String pathFilename) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource(pathFilename);
        return Files.readString(Paths.get(classPathResource.getFile().getCanonicalPath()));
    }

    /**
     *
     * @param jsonPath path to the json file
     * @param clazz the class where to deserialize the json
     * @param <T> same type as clazz
     * @return T object mapped from provided json
     * @throws Exception when deserialization fails
     */
    public static <T> T mapJsonFromPath(String jsonPath, Class<T> clazz) throws Exception {
        return mapJson(readFileFromClasspath(jsonPath), clazz);
    }

    /**
     *
     * @param json json to be deserialized
     * @param clazz the class where to deserialize the json
     * @param <T> same type as clazz
     * @return T object mapped from provided json
     * @throws Exception when deserialization fails
     */
    public static <T> T mapJson(String json, Class<T> clazz) throws Exception {
        return getObjectMapper().readValue(json, clazz);
    }

    private static ObjectMapper getObjectMapper() {
        if (OBJECT_MAPPER == null) {
            OBJECT_MAPPER = new ObjectMapper();
        }
        return OBJECT_MAPPER;
    }
}
