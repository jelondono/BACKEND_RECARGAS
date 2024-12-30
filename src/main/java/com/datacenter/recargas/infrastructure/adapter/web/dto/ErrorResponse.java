package com.datacenter.recargas.infrastructure.adapter.web.dto;

import java.time.LocalDateTime;

public class ErrorResponse {
    private final int statusCode;
    private final String message;
    private final LocalDateTime timestamp;

    public ErrorResponse(int statusCode, String message, LocalDateTime timestamp) {
        this.statusCode = statusCode;
        this.message = message;
        this.timestamp = timestamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
