package ua.vholovetskyi.expensessplit.shared.exception;

public class ResourceNotFoundException extends BusinessException {

    public ResourceNotFoundException(String resource) {
        super("The resource: %s does not exist".formatted(resource));
    }
}
