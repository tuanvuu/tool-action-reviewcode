package com.reviewcode.tool.exception;

import com.reviewcode.tool.constants.error.IErrorCode;
import org.springframework.http.HttpStatus;

import java.text.MessageFormat;

public class BadRequestException extends HandledException {

    private BadRequestException(IErrorCode errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public static BadRequestException from(IErrorCode errorCode) {
        return new BadRequestException(errorCode, errorCode.getMessage());
    }

    public static BadRequestException from(IErrorCode errorCode, Object... params) {
        return params.length == 0
            ? from(errorCode)
            : new BadRequestException(errorCode, MessageFormat.format(errorCode.getMessage(), params));
    }

    public static BadRequestException fromErrorCodeWithCustomMessage(IErrorCode errorCode, String errorMessage) {
        return new BadRequestException(errorCode, errorMessage);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.OK;
    }
}
