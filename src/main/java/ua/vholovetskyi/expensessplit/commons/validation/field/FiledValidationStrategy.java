package ua.vholovetskyi.expensessplit.commons.validation.field;

import ua.vholovetskyi.expensessplit.commons.validation.field.model.BrokenField;

import java.lang.reflect.Field;

public interface FiledValidationStrategy {

    BrokenField validate(Field field, Object dto);
}
