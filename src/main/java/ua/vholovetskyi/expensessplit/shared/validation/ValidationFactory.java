package ua.vholovetskyi.expensessplit.shared.validation;

import ua.vholovetskyi.expensessplit.shared.validation.annotation.marker.CustomValidation;
import ua.vholovetskyi.expensessplit.shared.validation.exceptions.ValidationException;
import ua.vholovetskyi.expensessplit.shared.validation.field.FiledValidator;
import ua.vholovetskyi.expensessplit.shared.validation.field.model.BrokenField;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ValidationFactory implements Validation {

    private final Map<Class<? extends Annotation>, FiledValidator> validationFunctions;
    private final Set<Class<? extends Annotation>> supportedAnnotation;

    public ValidationFactory(Map<Class<? extends Annotation>, FiledValidator> validations) {
        this.validationFunctions = validations;
        this.supportedAnnotation = validations.keySet();
    }

    @Override
    public ValidationResult validate(Object bean) {
        ValidationResult result = new ValidationResult();
        if (bean == null) {
            throw new ValidationException("Enter object is null");
        }

        Class<?> clazz = bean.getClass();

        if (!clazz.isAnnotationPresent(CustomValidation.class)) {
            throw new ValidationException("Not supported object");
        }
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            List<BrokenField> brokenFields = supportedAnnotation.stream()
                    .filter(field::isAnnotationPresent)
                    .map(validationFunctions::get)
                    .map(filedValidator -> filedValidator.validate(field, bean))
                    .filter(BrokenField::isValid)
                    .toList();

            result.addBrokenField(brokenFields);
        }
        return result;
    }
}
