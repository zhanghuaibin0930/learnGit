package com.example.demo.common;

public class ResponseHelper {

    public static <T> Response<T> createResponse(int code) {
        Response<T> response = new Response();
        response.setCode(code);
        return response;
    }

    public static <T> Response<T> createResponse(int code, String description) {
        Response<T> response = new Response();
        response.setCode(code);
        response.setDescription(description);
        return response;
    }

    public static <T> Response<T> createResponse(int code, String description, long lastUpdateTime) {
        Response<T> response = new Response();
        response.setCode(code);
        response.setDescription(description);
        response.setLastUpdateTime(lastUpdateTime);
        return response;
    }

    public static <T> Response<T> createSuccessResponse() {
        return createResponse(ResultCode.SUCCESS.getCode());
    }

    public static <T> Response<T> createSuccessResponse(T payload) {
        Response<T> response = createResponse(ResultCode.SUCCESS.getCode());
        response.setPayload(payload);
        return response;
    }

    public static <T> Response<T> createExceptionResponse(Exception e) {
        return createResponse(500, e.getMessage());
    }

    public static <T> Response<T> createParameterErrorResponse(String description) {
        return createResponse(1001, description);
    }
}
