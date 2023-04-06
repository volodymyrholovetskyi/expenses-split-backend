package ua.vholovetskyi.expensessplit.shared.validation.field.impl;

import org.apache.logging.log4j.util.Strings;
import ua.vholovetskyi.expensessplit.shared.validation.annotation.Required;
import ua.vholovetskyi.expensessplit.shared.validation.exceptions.ValidationException;
import ua.vholovetskyi.expensessplit.shared.validation.field.FiledValidator;
import ua.vholovetskyi.expensessplit.shared.validation.field.model.BrokenField;

import java.lang.reflect.Field;

public class RequiredFiledValidation implements FiledValidator {

    @Override
    public BrokenField validate(Field field, Object dto) {
        if (field.isAnnotationPresent(Required.class)) {
            try {
               String filedValue =  (String) field.get(dto);
               if (Strings.isBlank(filedValue))
                return BrokenField.error(field.getName(), filedValue);
            } catch (IllegalAccessException e) {
                throw new ValidationException("RequiredFiledValidation", e);
            }
        }
        return BrokenField.isEmpty();
    }
}
