package ua.vholovetskyi.expensessplit.common.exception;

public class DuplicateResourceException extends BusinessException{
    protected DuplicateResourceException(String resource) {
        super("The resource: %s already exists".formatted(resource));
    }
}
