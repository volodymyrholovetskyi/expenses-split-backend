package ua.vholovetskyi.expensessplit.shared.validation.field;

import ua.vholovetskyi.expensessplit.shared.validation.field.model.BrokenField;

import java.lang.reflect.Field;

public interface FiledValidation {

    BrokenField validate(Field field, Object dto);
}
