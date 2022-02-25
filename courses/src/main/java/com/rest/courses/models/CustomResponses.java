package com.rest.courses.models;


import org.springframework.stereotype.Component;

@Component
public class CustomResponses {
    private String response;
    private Integer responseCode;


    public CustomResponses(String response, Integer responseCode) {
        this.response = response;
        this.responseCode = responseCode;
    }

    public CustomResponses() {
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }
}
