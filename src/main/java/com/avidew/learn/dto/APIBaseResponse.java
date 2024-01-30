package com.avidew.learn.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)

public class APIBaseResponse<T> implements Serializable{
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    /** The response dto. */
    private ResponseDto responseDto;
    /** The Data to be send to UI */
    private T data;

    public APIBaseResponse() {
        super();
        this.responseDto = new ResponseDto();
    }

    public APIBaseResponse(ResponseDto responseDto) {
        super();
        this.responseDto = responseDto;
    }

    public APIBaseResponse(ResponseDto responseDto, T data) {
        super();
        this.responseDto = responseDto;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponseDto getResponseDto() {
        return responseDto;
    }

    public void setResponseDto(ResponseDto responseDto) {
        this.responseDto = responseDto;
    }
}
