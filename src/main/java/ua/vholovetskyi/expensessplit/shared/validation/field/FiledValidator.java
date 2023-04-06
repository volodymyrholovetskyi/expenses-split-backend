package ua.vholovetskyi.expensessplit.shared.validation.field;

import ua.vholovetskyi.expensessplit.shared.validation.field.model.BrokenField;

import java.lang.reflect.Field;

public interface FiledValidator {

    BrokenField validate(Field field, Object dto);
}
