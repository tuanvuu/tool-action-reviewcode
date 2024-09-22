package com.reviewcode.tool.converter;



import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import lombok.experimental.UtilityClass;
import retrofit2.converter.jackson.JacksonConverterFactory;

@UtilityClass
public class Jksonizer {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        SimpleModule module = new SimpleModule();
        objectMapper.registerModule(module);
    }


    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public static JacksonConverterFactory getConverterFactory() {
        return JacksonConverterFactory.create(objectMapper);
    }
}
