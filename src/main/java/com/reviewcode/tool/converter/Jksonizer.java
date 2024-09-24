package com.reviewcode.tool.converter;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.reviewcode.tool.constants.error.GeneralResultCode;
import com.reviewcode.tool.exception.InternalServerErrorException;
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

    public static String toJson(Object payload) {
        try {
            return objectMapper.writeValueAsString(payload);
        } catch (JsonProcessingException e) {
            throw InternalServerErrorException.from(GeneralResultCode.JSON_PARSER_FAIL);
        }
    }
}
