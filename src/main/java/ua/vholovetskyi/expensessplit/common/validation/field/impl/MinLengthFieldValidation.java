package ua.vholovetskyi.expensessplit.common.validation.field.impl;

import ua.vholovetskyi.expensessplit.common.validation.annotation.MinLength;
import ua.vholovetskyi.expensessplit.common.validation.exception.ValidationException;
import ua.vholovetskyi.expensessplit.common.validation.field.FiledValidation;
import ua.vholovetskyi.expensessplit.common.validation.field.model.BrokenField;

import java.lang.reflect.Field;
import java.util.Objects;

import static ua.vholovetskyi.expensessplit.common.validation.field.utils.MessageViolationFieldUtils.MIN_LENGTH_MESSAGE;

public class MinLengthFieldValidation implements FiledValidation {

    @Override
    public BrokenField validate(Field field, Object dto) {
        if (field.isAnnotationPresent(MinLength.class)) {
            try {
                Object filedValue = field.get(dto);
                MinLength annotation = field.getAnnotation(MinLength.class);
                if (Objects.isNull(filedValue)) {
                    return BrokenField.create(field.getName(), null, MIN_LENGTH_MESSAGE.formatted(field.getName(), annotation.min()));
                } else if (annotation.min() > filedValue.toString().length())
                    return BrokenField.create(field.getName(), filedValue, MIN_LENGTH_MESSAGE.formatted(field.getName(), annotation.min()));
            } catch (IllegalAccessException e) {
                throw new ValidationException("Error in class MinLengthFieldValidation!");
            }
        }
        return null;
    }
}
