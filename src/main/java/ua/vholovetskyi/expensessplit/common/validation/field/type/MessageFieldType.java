package ua.vholovetskyi.expensessplit.common.validation.field.type;

public enum MessageFieldType {

    NOT_NULL_MESSAGE("The field: %s cannot be %s"),

    MIN_LENGTH_MESSAGE("Field: %s, must contain at least %d characters");

    final String message;

    MessageFieldType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
