package com.reviewcode.tool.exception;

import com.reviewcode.tool.constants.error.IErrorCode;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

@Getter
public abstract class HandledException extends RuntimeException {
    protected IErrorCode errorCode;
    protected String errorMessage;

    protected HandledException(IErrorCode errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return StringUtils.defaultIfEmpty(errorMessage, errorCode.getMessage());
    }

    public abstract HttpStatus getHttpStatus();
}
