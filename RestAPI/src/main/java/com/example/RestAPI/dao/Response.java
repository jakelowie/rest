package com.example.RestAPI.dao;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Response<T> {

    private String status;

    private Map<String, Object> data;

    private int code;

    private Map<String, Object> error;

    public Response() {
    }

    public Response(String status, Map<String, Object> data) {
        this.status = status;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, Object> getError() {
        return error;
    }

    public void setError(Map<String, Object> error) {
        this.error = error;
    }
}
