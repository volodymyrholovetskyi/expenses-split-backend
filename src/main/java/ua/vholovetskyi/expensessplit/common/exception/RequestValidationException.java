package ua.vholovetskyi.expensessplit.common.exception;

import ua.vholovetskyi.expensessplit.common.validation.field.model.BrokenField;

public class RequestValidationException extends RuntimeException {

    private final BrokenField brokenFields;

    public RequestValidationException(BrokenField brokenFields) {
        super(brokenFields.getMessage());
        this.brokenFields = brokenFields;
    }

    public BrokenField getBrokenField() {
        return brokenFields;
    }
}
