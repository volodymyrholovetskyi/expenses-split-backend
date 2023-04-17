package ua.vholovetskyi.expensessplit.common.validation.field.type;

import ua.vholovetskyi.expensessplit.common.validation.annotation.MinLength;
import ua.vholovetskyi.expensessplit.common.validation.annotation.NotNull;
import ua.vholovetskyi.expensessplit.common.validation.field.FiledValidationStrategy;
import ua.vholovetskyi.expensessplit.common.validation.field.impl.MinLengthFieldValidationStrategy;
import ua.vholovetskyi.expensessplit.common.validation.field.impl.NotNullFiledValidationStrategy;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

public enum AnnotationType {

    MIN_LENGTH(MinLength.class, new MinLengthFieldValidationStrategy()),
    NOT_NULL(NotNull.class, new NotNullFiledValidationStrategy());

    private final Class<? extends Annotation> annotation;
    private final FiledValidationStrategy validationStrategy;

    AnnotationType(Class<? extends Annotation> annotation, FiledValidationStrategy validationStrategy) {
        this.annotation = annotation;
        this.validationStrategy = validationStrategy;
    }

    public static Map<Class<? extends Annotation>, FiledValidationStrategy> getInstancesByAnnotation(AnnotationType... annotationTypes) {
        Map<Class<? extends Annotation>, FiledValidationStrategy> validationFunctions = new HashMap<>(annotationTypes.length);
        for (AnnotationType annotationType : annotationTypes) {
            validationFunctions.put(annotationType.annotation, annotationType.validationStrategy);
        }
        return validationFunctions;
    }
}
