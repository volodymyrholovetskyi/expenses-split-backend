package ua.vholovetskyi.expensessplit.commons.exception;

public class ResourceNotFoundException extends BusinessException {

    public ResourceNotFoundException(String id) {
        super("Group with ID: %s not found".formatted(id));
    }
}
