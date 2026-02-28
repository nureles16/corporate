package guru.springframework.corporate.exception;

import java.time.LocalDateTime;
import java.util.Map;

public class ValidationErrorResponse extends ErrorResponse {

    private Map<String, String> errors;

    public ValidationErrorResponse(LocalDateTime timestamp, int status, String message, Map<String, String> errors) {
        super(timestamp, status, message);
        this.errors = errors;
    }

    public Map<String, String> getErrors() { return errors; }
    public void setErrors(Map<String, String> errors) { this.errors = errors; }
}