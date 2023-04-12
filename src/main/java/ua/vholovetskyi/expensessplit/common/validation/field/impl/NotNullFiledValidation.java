package ua.vholovetskyi.expensessplit.common.validation.field.impl;

import ua.vholovetskyi.expensessplit.common.validation.annotation.NotNull;
import ua.vholovetskyi.expensessplit.common.validation.exception.ValidationException;
import ua.vholovetskyi.expensessplit.common.validation.field.FiledValidation;
import ua.vholovetskyi.expensessplit.common.validation.field.model.BrokenField;

import java.lang.reflect.Field;
import java.util.Objects;

import static ua.vholovetskyi.expensessplit.common.validation.field.utils.MessageViolationFieldUtils.*;

public class NotNullFiledValidation implements FiledValidation {

    @Override
    public BrokenField validate(Field field, Object dto) {
        if (field.isAnnotationPresent(NotNull.class)) {
            try {
               Object filedValue =  field.get(dto);
               if (Objects.isNull(filedValue))
                return BrokenField.create(field.getName(), null, NOT_NULL_MESSAGE.formatted(field.getName(), null));
            } catch (IllegalAccessException e) {
                throw new ValidationException("Error in class NotNullFiledValidation!");
            }
        }
        return null;
    }
}
