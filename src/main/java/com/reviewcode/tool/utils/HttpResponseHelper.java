package com.reviewcode.tool.utils;

import com.reviewcode.tool.constants.error.IErrorCode;
import com.reviewcode.tool.dto.result.CommonResult;
import com.reviewcode.tool.exception.HandledException;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Slf4j
@UtilityClass
public class HttpResponseHelper {

    public static <T> ResponseEntity<CommonResult<T>> successWith(T data) {
        return ResponseEntity.ok(CommonResult.successWith(data));
    }




    public static <T> ResponseEntity<CommonResult<T>> failBy(HttpStatus httpStatus, IErrorCode errorCode, String... msgParameter) {
        CommonResult<T> commonResult = CommonResult.failBy(errorCode, msgParameter);
        return new ResponseEntity<>(commonResult, httpStatus);
    }

    public static <T> ResponseEntity<CommonResult<T>> failBy(HandledException handledException) {
        CommonResult<T> commonResult = CommonResult.failBy(handledException.getErrorCode(), handledException.getErrorMessage());
        return new ResponseEntity<>(commonResult, handledException.getHttpStatus());
    }
}
