package ua.vholovetskyi.expensessplit.common.validation.exception;

import ua.vholovetskyi.expensessplit.common.validation.Validation;

public class ValidationException extends RuntimeException{

    public ValidationException(String message) {
        super(message);
    }
}
