package com.bsolz.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * Global Exception Handler for Product-related API endpoints.
 * * This class uses @RestControllerAdvice to intercept exceptions thrown by any
 * Controller. It ensures that instead of a generic internal server error,
 * the client receives a structured JSON response with specific validation details.
 */
@RestControllerAdvice
public class ProductExceptionHandler {

    /**
     * Intercepts validation failures that occur during the binding of request data.
     * * When a @Valid annotated object (like RequestBrand) fails its constraints
     * (@NotNull, @ValidFile, etc.), Spring throws a MethodArgumentNotValidException.
     * * @param exception The exception containing details about the failed constraints.
     * @return A map of field names and their corresponding error messages with a 400 Bad Request status.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();

        // Extract each field-level error and map it (e.g., "image" -> "Image is required")
        exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        });

        // Return a clean JSON object to the frontend/client
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
