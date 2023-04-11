package ua.vholovetskyi.expensessplit.shared.validation.field.impl;

import ua.vholovetskyi.expensessplit.shared.validation.annotation.NotNull;
import ua.vholovetskyi.expensessplit.shared.validation.exceptions.ValidationException;
import ua.vholovetskyi.expensessplit.shared.validation.field.FiledValidation;
import ua.vholovetskyi.expensessplit.shared.validation.field.model.BrokenField;

import java.lang.reflect.Field;
import java.util.Objects;

import static ua.vholovetskyi.expensessplit.shared.validation.field.utils.MessageViolationFieldUtils.*;

public class NotNullFiledValidation implements FiledValidation {

    @Override
    public BrokenField validate(Field field, Object dto) {
        if (field.isAnnotationPresent(NotNull.class)) {
            try {
               Object filedValue =  field.get(dto);
               if (Objects.isNull(filedValue))
                return BrokenField.create(field.getName(), null, NOT_NULL_MESSAGE.formatted(field.getName(), null));
            } catch (IllegalAccessException e) {
                throw new ValidationException("RequiredFiledValidation", e);
            }
        }
        return null;
    }
}
