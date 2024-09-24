package com.reviewcode.tool.dto.result;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Error {
    private String code;
    private String message;

    private Error(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static Error from(String code, String message) {
        return new Error(code, message);
    }
}
