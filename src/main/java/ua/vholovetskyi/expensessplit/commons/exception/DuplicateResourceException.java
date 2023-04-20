package ua.vholovetskyi.expensessplit.commons.exception;

public class DuplicateResourceException extends BusinessException{
    protected DuplicateResourceException(String resource) {
        super("The resource: %s already exists".formatted(resource));
    }
}
