package ua.vholovetskyi.expensessplit.expense.domain.model;

import lombok.extern.slf4j.Slf4j;
import ua.vholovetskyi.expensessplit.common.exception.RequestValidationException;
import ua.vholovetskyi.expensessplit.common.validation.ValidationLogic;
import ua.vholovetskyi.expensessplit.common.validation.ValidationResult;
import ua.vholovetskyi.expensessplit.common.validation.annotation.MinLength;
import ua.vholovetskyi.expensessplit.common.validation.field.FiledValidation;
import ua.vholovetskyi.expensessplit.common.validation.field.impl.MinLengthFieldValidation;
import ua.vholovetskyi.expensessplit.common.validation.field.model.BrokenField;
import ua.vholovetskyi.expensessplit.expense.domain.dto.CreateGroupDto;
import ua.vholovetskyi.expensessplit.expense.domain.dto.GetGroupDto;
import ua.vholovetskyi.expensessplit.expense.domain.mapper.GroupDtoMapper;
import ua.vholovetskyi.expensessplit.expense.domain.model.type.StatusType;

import java.lang.annotation.Annotation;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class GroupFactory {

    private final ValidationLogic validation;
    private final Map<Class<? extends Annotation>, FiledValidation> annotations = new HashMap<>();

    public GroupFactory() {
        validation = new ValidationLogic(annotations);
    }

    public GetGroupDto createGroup(CreateGroupDto dto) {
        annotations.put(MinLength.class, new MinLengthFieldValidation());
        ValidationResult validate = validation.validate(dto);
        List<BrokenField> brokenFields = validate.getBrokenFields();

        if (!brokenFields.isEmpty()) {
            throw new RequestValidationException(brokenFields.get(0));
        }
        Group group = new Group(dto.name(), StatusType.NEW, dto.currency(),
                LocalDateTime.now(), LocalDateTime.now());
        return new GroupDtoMapper().apply(group);
    }
}













