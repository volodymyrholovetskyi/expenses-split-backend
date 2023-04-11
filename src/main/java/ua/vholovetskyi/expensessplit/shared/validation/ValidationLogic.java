package ua.vholovetskyi.expensessplit.shared.validation;

import ua.vholovetskyi.expensessplit.shared.validation.annotation.marker.CustomValidation;
import ua.vholovetskyi.expensessplit.shared.validation.exceptions.ValidationException;
import ua.vholovetskyi.expensessplit.shared.validation.field.FiledValidation;
import ua.vholovetskyi.expensessplit.shared.validation.field.model.BrokenField;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class ValidationLogic implements Validation {

    private final Map<Class<? extends Annotation>, FiledValidation> validationFunctions;
    private final Set<Class<? extends Annotation>> supportedAnnotation;

    public ValidationLogic(Map<Class<? extends Annotation>, FiledValidation> validationFunctions) {
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
                    .map(filedValidation -> filedValidation.validate(field, bean))
                    .filter(Objects::nonNull)
                    .toList();
            result.addBrokenField(brokenFields);
        }
        return result;
    }
}
