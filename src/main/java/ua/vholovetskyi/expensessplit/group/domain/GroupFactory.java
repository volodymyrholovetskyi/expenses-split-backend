package ua.vholovetskyi.expensessplit.group.domain;

import ua.vholovetskyi.expensessplit.group.domain.dto.GroupDto;
import ua.vholovetskyi.expensessplit.group.domain.model.Group;
import ua.vholovetskyi.expensessplit.group.domain.model.StatusGroup;
import ua.vholovetskyi.expensessplit.shared.validation.ValidationFactory;
import ua.vholovetskyi.expensessplit.shared.validation.ValidationResult;
import ua.vholovetskyi.expensessplit.shared.validation.annotation.marker.CustomValidation;
import ua.vholovetskyi.expensessplit.shared.validation.field.FiledValidator;
import ua.vholovetskyi.expensessplit.shared.validation.field.impl.RequiredFiledValidation;
import ua.vholovetskyi.expensessplit.shared.validation.field.model.BrokenField;

import java.lang.annotation.Annotation;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupFactory {

    private final ValidationFactory validation;

    public GroupFactory() {
        Map<Class<? extends Annotation>, FiledValidator> annotations = new HashMap<>();
        annotations.put(CustomValidation.class, new RequiredFiledValidation());
        validation = new ValidationFactory(annotations);
    }

    public GroupDto createGroup(GroupDto dto) {
        ValidationResult validate = validation.validate(dto);
        List<BrokenField> brokenFields = validate.getBrokenFields();
        if (!brokenFields.isEmpty()){
            throw new RuntimeException();
        }
        Group group = new Group(dto.name(), StatusGroup.NEW, LocalDateTime.now(), LocalDateTime.now());
        return new GroupDto(group.getName());
    }
}
