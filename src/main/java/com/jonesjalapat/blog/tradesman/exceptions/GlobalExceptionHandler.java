package com.jonesjalapat.blog.tradesman.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  public static final String TRADE_NOT_SUPPORTED = "The trade is not supported";

  @ExceptionHandler(TradeNotSupportedException.class)
  public ResponseEntity<ErrorResponse> handleTradeNotSupportedException(
      TradeNotSupportedException exception) {
    log.error(exception.getMessage());
    return ResponseEntity.status(HttpStatus.FORBIDDEN)
        .body(ErrorResponse.builder().message(TRADE_NOT_SUPPORTED).build());
  }
}
