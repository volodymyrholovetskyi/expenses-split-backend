package ua.vholovetskyi.expensessplit.commons.validation.field.type;

import ua.vholovetskyi.expensessplit.commons.validation.annotation.MinLength;
import ua.vholovetskyi.expensessplit.commons.validation.annotation.NotNull;
import ua.vholovetskyi.expensessplit.commons.validation.field.FiledValidationStrategy;
import ua.vholovetskyi.expensessplit.commons.validation.field.impl.MinLengthFieldValidationStrategy;
import ua.vholovetskyi.expensessplit.commons.validation.field.impl.NotNullFiledValidationStrategy;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum AnnotationType {

    MIN_LENGTH(MinLength.class, new MinLengthFieldValidationStrategy()),
    NOT_NULL(NotNull.class, new NotNullFiledValidationStrategy());

    private final Class<? extends Annotation> annotation;
    private final FiledValidationStrategy validationStrategy;

    AnnotationType(Class<? extends Annotation> annotation, FiledValidationStrategy validationStrategy) {
        this.annotation = annotation;
        this.validationStrategy = validationStrategy;
    }

    public static Map<Class<? extends Annotation>, FiledValidationStrategy> getInstancesByAnnotation() {
        return Arrays.stream(values())
                .collect(Collectors.toMap(k -> k.annotation, v -> v.validationStrategy));
    }
}
