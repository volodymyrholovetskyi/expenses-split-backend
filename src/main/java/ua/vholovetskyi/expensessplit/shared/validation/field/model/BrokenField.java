package ua.vholovetskyi.expensessplit.shared.validation.field.model;

public class BrokenField {
    private final String filedName;
    private final Object filedValue;
    private final boolean isValid;

    private BrokenField(String filedName, Object filedValue, boolean isValid) {
        this.filedName = filedName;
        this.filedValue = filedValue;
        this.isValid = isValid;
    }

    public static BrokenField isEmpty() {
        return new BrokenField(null, null, true);
    }

    public static BrokenField error(String filedName, Object filedValue) {
        return new BrokenField(filedName, filedValue, false);
    }

    public boolean isValid() {
        return isValid;
    }
}
