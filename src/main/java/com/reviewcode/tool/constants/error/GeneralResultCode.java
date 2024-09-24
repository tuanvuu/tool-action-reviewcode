package com.reviewcode.tool.constants.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GeneralResultCode implements IErrorCode {
    /* HTTP CODE: 200 */
    SUCCESS(200, "SUCCESS"),

    /* HTTP CODE: 401 */
    INVALID_JWT_IDENTITY(401, "invalid jwt identity"),
    INVALID_REQUEST_HEADER(401, "invalid request header"),

    /* HTTP CODE: 403 */
    PERMISSION_DENIED(403, "PERMISSION_DENIED"),
    MISSING_PARAM(400, "missing param {0}"),
    WRONG_PARAM_FOUND(400, "wrong param {0}"),
    INVALID_FORMAT_PARAM(400, "invalid format param {0}"),


    /* HTTP CODE: 404 */
    INVALID_ITEM(404, "Invalid item {0}."),
    INVALID_PARAMS(404, "Invalid params."),
    PARTNER_VALIDATION(404, "Failed validation from partner."),
    NOT_SUPPORT_OPERATION(404, "Not support operation."),
    METHOD_NOT_ALLOWED(404, "Method not allowed."),
    /* HTTP CODE: 500 */
    BUSY_SYSTEM(500, "busy system"),
    AGENT_NOT_AVAILABLE(500, "agent not available"),
    JSON_PARSER_FAIL(500, "Cannot parse object.");

    private int code;
    private String message;


}
