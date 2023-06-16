package com.onetoone.responseHandlers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {

    public static ResponseEntity<Object> generateResponse(String message, HttpStatus httpStatus,
            Object responseObject) {
        Map<String, Object> responseMap = new HashMap<String, Object>();
        responseMap.put("message", message);
        responseMap.put("status", httpStatus.value());

        if (responseObject != null) {
            responseMap.put("data", responseObject);
        }

        return new ResponseEntity<Object>(responseMap, httpStatus);

    }

    public static ResponseEntity<Object> generateResponse(String message, HttpStatus httpStatus,
            List<Object> responseObject) {
        Map<String, Object> responseMap = new HashMap<String, Object>();
        responseMap.put("message", message);
        responseMap.put("status", httpStatus.value());

        if (responseObject != null) {
            responseMap.put("data", responseObject);
        }

        return new ResponseEntity<Object>(responseMap, httpStatus);

    }

    public static ResponseEntity<Object> ok(Object responseObject) {
        return generateResponse("Successfully retrieved data!", HttpStatus.OK, responseObject);
    }

     public static ResponseEntity<Object> ok(List<Object> responseObject) {
        return generateResponse("Successfully retrieved data!", HttpStatus.OK, responseObject);
    }

    public static ResponseEntity<Object> created(Object responseObject) {
        return generateResponse("Successfully added data!", HttpStatus.CREATED, responseObject);
    }

    public static ResponseEntity<Object> updated(Object responseObject) {
        return generateResponse("Successfully updated data!", HttpStatus.OK, responseObject);
    }

    public static ResponseEntity<Object> deleted() {
        return generateResponse("Successfully deleted data!", HttpStatus.OK, null);
    }

    public static ResponseEntity<Object> notFound() {
        return generateResponse("Data Not Found!", HttpStatus.NOT_FOUND, null);
    }

    public static ResponseEntity<Object> error() {
        return generateResponse("Error System", HttpStatus.INTERNAL_SERVER_ERROR, null);
    }

}
