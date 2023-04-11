package ua.vholovetskyi.expensessplit.shared.exception;

public class RequestValidationException extends BusinessException {
    protected RequestValidationException(String message) {
        super(message);
    }
}
