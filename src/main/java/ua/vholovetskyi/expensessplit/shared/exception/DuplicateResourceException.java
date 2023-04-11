package ua.vholovetskyi.expensessplit.shared.exception;

public class DuplicateResourceException extends BusinessException{
    protected DuplicateResourceException(String resource) {
        super("The resource: %s already exists".formatted(resource));
    }
}
