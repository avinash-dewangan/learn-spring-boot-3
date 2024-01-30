package com.avidew.learn.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

public class ResponseDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private int responseCode;
    private String responseDescription;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private int exceptionCode;
    private String exceptionDescription;
    private Integer status;
    private String message;
    private Integer specialCode;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseDto() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public ResponseDto(int responseCode, String responseDescription) {
        this.responseCode = responseCode;
        this.responseDescription = responseDescription;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseDescription() {
        return responseDescription;
    }

    public void setResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;
    }

    public int getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(int exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public String getExceptionDescription() {
        return exceptionDescription;
    }

    public void setExceptionDescription(String exceptionDescription) {
        this.exceptionDescription = exceptionDescription;
    }

    public Integer getSpecialCode() {
        return specialCode;
    }

    public void setSpecialCode(Integer specialCode) {
        this.specialCode = specialCode;
    }
}
