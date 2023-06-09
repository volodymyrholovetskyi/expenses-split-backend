package ua.vholovetskyi.expensessplit.commons.validation;

import ua.vholovetskyi.expensessplit.commons.validation.annotation.marker.CustomValidation;
import ua.vholovetskyi.expensessplit.commons.validation.exception.ValidationException;
import ua.vholovetskyi.expensessplit.commons.validation.field.FiledValidationStrategy;
import ua.vholovetskyi.expensessplit.commons.validation.field.model.BrokenField;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class ValidationFieldLogic implements Validation {

    private final Map<Class<? extends Annotation>, FiledValidationStrategy> validationFunctions;
    private final Set<Class<? extends Annotation>> supportedAnnotation;

    public ValidationFieldLogic(Map<Class<? extends Annotation>, FiledValidationStrategy> validationFunctions) {
        this.validationFunctions = validationFunctions;
        this.supportedAnnotation = validationFunctions.keySet();
    }

    @Override
    public ValidationResult validate(Object bean) {
        ValidationResult result = new ValidationResult();
        if (bean == null) {
            throw new ValidationException("The validation object cannot be empty!");
        }
        Class<?> clazz = bean.getClass();
        if (!clazz.isAnnotationPresent(CustomValidation.class)) {
            throw new ValidationException("Unsupported object: " + clazz.getName());
        }
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            List<BrokenField> brokenFields = supportedAnnotation.stream()
                    .filter(field::isAnnotationPresent)
                    .map(validationFunctions::get)
                    .map(filedValidationStrategy -> filedValidationStrategy.validate(field, bean))
                    .filter(Objects::nonNull)
                    .toList();
            result.addBrokenField(brokenFields);
        }
        return result;
    }
}
