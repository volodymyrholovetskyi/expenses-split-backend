package ua.vholovetskyi.expensessplit.shared.validation.field.impl;

import ua.vholovetskyi.expensessplit.shared.validation.annotation.MinLength;
import ua.vholovetskyi.expensessplit.shared.validation.exceptions.ValidationException;
import ua.vholovetskyi.expensessplit.shared.validation.field.FiledValidation;
import ua.vholovetskyi.expensessplit.shared.validation.field.model.BrokenField;

import java.lang.reflect.Field;

import static ua.vholovetskyi.expensessplit.shared.validation.field.utils.MessageViolationFieldUtils.MIN_LENGTH_MESSAGE;

public class MinLengthFieldValidation implements FiledValidation {

    @Override
    public BrokenField validate(Field field, Object dto) {
        if (field.isAnnotationPresent(MinLength.class)) {
            try {
                Object filedValue = field.get(dto);
                MinLength annotation = field.getAnnotation(MinLength.class);
                if (annotation.min() > 0)
                    return BrokenField.create(field.getName(), filedValue, MIN_LENGTH_MESSAGE.formatted(field.getName(), annotation.min()));
            } catch (IllegalAccessException e) {
                throw new ValidationException("RequiredFiledValidation", e);
            }
        }
        return null;
    }
}
