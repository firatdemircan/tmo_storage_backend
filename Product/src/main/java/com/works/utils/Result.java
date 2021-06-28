package com.works.utils;

import lombok.Data;

@Data
public class Result<T> {

    private boolean status;
    private String message;
    private T data;

    public Result(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public Result(boolean status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
