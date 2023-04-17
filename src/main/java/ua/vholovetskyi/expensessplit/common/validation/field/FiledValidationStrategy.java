package ua.vholovetskyi.expensessplit.common.validation.field;

import ua.vholovetskyi.expensessplit.common.validation.field.model.BrokenField;

import java.lang.reflect.Field;

public interface FiledValidationStrategy {

    BrokenField validate(Field field, Object dto);
}
