package com.reviewcode.tool.dto.result;


import com.reviewcode.tool.constants.error.GeneralResultCode;
import com.reviewcode.tool.constants.error.IErrorCode;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;


@Data
@Accessors(chain = true)
@SuperBuilder
public class CommonResult<T> {
    private String status;
    private int code;
    private String message;
    private T data;

    private CommonResult(GeneralResultCode generalResultCode) {
        this.code = generalResultCode.getCode();
        this.status = GeneralResultCode.SUCCESS.equals(generalResultCode) ? String.valueOf(true) : String.valueOf(false);
        this.message = generalResultCode.getMessage();
    }

    private CommonResult(IErrorCode errorCode, String... messages) {
        this.code = errorCode.getCode();
        this.message = messages.length > 0 ? messages[0] : errorCode.getMessage();
        this.status = String.valueOf(false);
    }

    public static <T> CommonResult<T> successWith(T data) {
        return new CommonResult<T>(GeneralResultCode.SUCCESS).setData(data);
    }

    public static <T> CommonResult<T> failBy(IErrorCode errorCode, String... messages) {
        return new CommonResult<>(errorCode, messages);
    }


}
