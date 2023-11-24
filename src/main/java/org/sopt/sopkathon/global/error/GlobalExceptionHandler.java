package org.sopt.sopkathon.global.error;

import lombok.extern.slf4j.Slf4j;
import org.sopt.sopkathon.global.common.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ApiResponse<?>> handleBusinessException(final BusinessException e) {
        log.error(">>> handle: BusinessException ", e);
        return ApiResponse.failure(e.getErrorStatus());
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ApiResponse<?>> handleException(final Exception e) {
        log.error(">>> handle: Exception ", e);
        return ApiResponse.failure(ErrorStatus.INTERNAL_SERVER_ERROR);
    }
}