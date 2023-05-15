package io.maddennis.turnkeychallenge.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ApiError {

    private int status;
    private String message;
    private String path;
    private LocalDateTime dateTime;
    private Map<String, String> validationErrors = new HashMap<>();

    public ApiError(int status, String message, String path) {
        this.status = status;
        this.message = message;
        this.path = path;
        this.dateTime = LocalDateTime.now();
    }
}
