package com.example.odrowonsz.models.body_models;

public record Response<T>(
        T data,
        String error

) {
    public static <T> Response<T> withOkStatus(T data) {
        return new Response<>(data, "");
    }

    public static <T> Response<T> withError(String error) {
        return new Response<>(null, error);
    }
}
