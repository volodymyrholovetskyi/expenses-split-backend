package ua.vholovetskyi.expensessplit.common.validation.field.model;

public class BrokenField {
    private final String filedName;
    private final Object filedValue;

    private final String message;

    private BrokenField(String filedName, Object filedValue, String message) {
        this.filedName = filedName;
        this.filedValue = filedValue;
        this.message = message;
    }

    public static BrokenField create(String filedName, Object filedValue, String messageViolation) {
        return new BrokenField(filedName, filedValue, messageViolation);
    }

    public String getFiledName() {
        return filedName;
    }

    public Object getFiledValue() {
        return filedValue;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "BrokenField{" +
                "filedName='" + filedName + '\'' +
                ", filedValue=" + filedValue +
                ", message='" + message + '\'' +
                '}';
    }
}
