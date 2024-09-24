package com.reviewcode.tool.exception.handler;


import com.reviewcode.tool.constants.error.GeneralResultCode;
import com.reviewcode.tool.converter.Jksonizer;
import com.reviewcode.tool.dto.result.CommonResult;
import com.reviewcode.tool.exception.BadRequestException;
import com.reviewcode.tool.exception.HandledException;
import com.reviewcode.tool.exception.InternalServerErrorException;
import com.reviewcode.tool.utils.HttpResponseHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.security.InvalidParameterException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {InternalServerErrorException.class})
    public ResponseEntity<CommonResult<Object>> handledInternalErrorException(HandledException ex, WebRequest request) {
        log.error("handledInternalErrorException -- exception handler: {}, result ent: {}",
                ex.getErrorMessage(),
                Jksonizer.toJson(ex.getErrorCode()),ex);
        return HttpResponseHelper.failBy(ex);
    }


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<CommonResult<Object>> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex) {
        log.error("contextPath: {}, handleMethodArgumentTypeMismatch: {}",
                ex.getErrorCode(), ex.getMessage(),ex);
        return HttpResponseHelper.failBy(BadRequestException.from(GeneralResultCode.INVALID_FORMAT_PARAM));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("handleMethodArgumentNotValid -- exception: {}", ex.getMessage(),ex);
        return ResponseEntity.badRequest().body(CommonResult.failBy(GeneralResultCode.INVALID_PARAMS,
                ex.getBindingResult().getFieldErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .toArray(String[]::new)));
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("handleHttpMessageNotReadable: {}", ex.getMessage(),ex);
        return ResponseEntity.badRequest().body(CommonResult.failBy(GeneralResultCode.INVALID_PARAMS, ex.getMessage()));
    }


    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("handleMissingServletRequestParameter -- {}", ex.getMessage(),ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(CommonResult.failBy(GeneralResultCode.MISSING_PARAM));
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("handleMethodNotAllowed -- ", ex.getMessage(),ex);
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(CommonResult.failBy(GeneralResultCode.METHOD_NOT_ALLOWED));
    }

    @Override
    protected ResponseEntity<Object> handleConversionNotSupported(ConversionNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("handleConversionNotSupported -- ", ex.getMessage(),ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(CommonResult.failBy(GeneralResultCode.INVALID_FORMAT_PARAM));
    }

    @ExceptionHandler(InvalidParameterException.class)
    public ResponseEntity<CommonResult<Object>> handleInvalidParameterException(InvalidParameterException ex, WebRequest request) {
        log.error("handleInvalidParameterException -- exception: {}", ex.getMessage(),ex);
        return HttpResponseHelper.failBy(BadRequestException.from(GeneralResultCode.INVALID_FORMAT_PARAM));
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        if (ex instanceof MethodArgumentNotValidException) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CommonResult<Object>> handleException(Exception ex) {
        log.error("handleException -- exception: {}",ex.getMessage(),ex);
        return HttpResponseHelper.failBy(InternalServerErrorException.from(GeneralResultCode.BUSY_SYSTEM));
    }



}
