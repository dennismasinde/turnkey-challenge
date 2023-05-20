package io.maddennis.turnkeychallenge.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class ApiAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handleNotFoundException(NotFoundException exception, HttpServletRequest request){
        log.error("Failed to find the requested element", exception);
        return new ApiError(404, exception.getMessage(), request.getServletPath());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleExceptionMethodArgumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request) {
        log.error("Validation errors for request {} ", request.getServletPath());
        //BindingResult bindingResult = exception
        return new ApiError(400, exception.getMessage(), request.getServletPath());
    }
}
