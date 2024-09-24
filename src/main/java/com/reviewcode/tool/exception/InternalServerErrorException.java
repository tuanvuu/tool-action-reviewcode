package com.reviewcode.tool.exception;

import com.reviewcode.tool.constants.error.IErrorCode;
import org.springframework.http.HttpStatus;

public class InternalServerErrorException extends HandledException {

    private InternalServerErrorException(IErrorCode errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public static InternalServerErrorException from(IErrorCode errorCode) {
        return new InternalServerErrorException(errorCode, errorCode.getMessage());
    }

    public static InternalServerErrorException from(IErrorCode errorCode, String errorMessage) {
        return new InternalServerErrorException(errorCode, errorMessage);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.OK;
    }
}
