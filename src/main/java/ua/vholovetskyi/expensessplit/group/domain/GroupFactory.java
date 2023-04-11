package ua.vholovetskyi.expensessplit.group.domain;

import lombok.extern.slf4j.Slf4j;
import ua.vholovetskyi.expensessplit.group.domain.dto.GroupDto;
import ua.vholovetskyi.expensessplit.group.domain.model.Group;
import ua.vholovetskyi.expensessplit.group.domain.model.StatusGroup;
import ua.vholovetskyi.expensessplit.shared.validation.ValidationLogic;
import ua.vholovetskyi.expensessplit.shared.validation.ValidationResult;
import ua.vholovetskyi.expensessplit.shared.validation.annotation.MinLength;
import ua.vholovetskyi.expensessplit.shared.validation.annotation.NotNull;
import ua.vholovetskyi.expensessplit.shared.validation.field.FiledValidation;
import ua.vholovetskyi.expensessplit.shared.validation.field.impl.MinLengthFieldValidation;
import ua.vholovetskyi.expensessplit.shared.validation.field.impl.NotNullFiledValidation;
import ua.vholovetskyi.expensessplit.shared.validation.field.model.BrokenField;

import java.lang.annotation.Annotation;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class GroupFactory {

    private final ValidationLogic validation;

    public GroupFactory() {
        Map<Class<? extends Annotation>, FiledValidation> annotations = new HashMap<>();
        annotations.put(NotNull.class, new NotNullFiledValidation());
        annotations.put(MinLength.class, new MinLengthFieldValidation());
        validation = new ValidationLogic(annotations);
    }

    public GroupDto createGroup(GroupDto dto) {
        ValidationResult validate = validation.validate(dto);
        List<BrokenField> brokenFields = validate.getBrokenFields();

        if (!brokenFields.isEmpty()) {
            brokenFields.stream().forEach(brokenField -> log.error(brokenField.getMessage()));
            throw new RuntimeException();
        }
        Group group = new Group(dto.name(), StatusGroup.NEW, LocalDateTime.now(), LocalDateTime.now());
        return new GroupDto(group.getName());
    }
}
