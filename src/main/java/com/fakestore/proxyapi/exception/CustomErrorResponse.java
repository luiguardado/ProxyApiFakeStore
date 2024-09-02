package com.fakestore.proxyapi.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

public record CustomErrorResponse(
    LocalDateTime dateTime,
    String message,
    String path
    )
{}

