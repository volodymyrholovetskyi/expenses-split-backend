package ua.vholovetskyi.expensessplit.groupexpense.domain;

import lombok.extern.slf4j.Slf4j;
import ua.vholovetskyi.expensessplit.common.exception.RequestValidationException;
import ua.vholovetskyi.expensessplit.common.validation.ValidationFieldLogic;
import ua.vholovetskyi.expensessplit.common.validation.ValidationResult;
import ua.vholovetskyi.expensessplit.common.validation.field.model.BrokenField;
import ua.vholovetskyi.expensessplit.common.validation.field.type.AnnotationType;
import ua.vholovetskyi.expensessplit.groupexpense.domain.dto.expense.CreateExpenseDto;
import ua.vholovetskyi.expensessplit.groupexpense.domain.dto.expense.GetExpenseDto;
import ua.vholovetskyi.expensessplit.groupexpense.domain.dto.group.CreateGroupDto;
import ua.vholovetskyi.expensessplit.groupexpense.domain.dto.group.GetGroupDto;
import ua.vholovetskyi.expensessplit.groupexpense.domain.type.StatusType;
import ua.vholovetskyi.expensessplit.groupexpense.domain.vo.Money;

import java.time.LocalDateTime;
import java.util.List;

import static ua.vholovetskyi.expensessplit.common.validation.field.type.AnnotationType.*;

@Slf4j
public class GroupExpenseFactory {
    public GetGroupDto createGroup(CreateGroupDto dto) {
        validator(dto, MIN_LENGTH, NOT_NULL);
        Group group = new Group(
                dto.name(),
                StatusType.NEW,
                dto.currency(),
                LocalDateTime.now(),
                LocalDateTime.now());
        return new GroupDtoMapper().apply(group);
    }

    public GetExpenseDto createExpense(CreateExpenseDto dto) {
        validator(dto, MIN_LENGTH, NOT_NULL);
        Expense expense = new Expense(
                dto.transaction(),
                Money.create(dto.amount(), dto.currency()),
                dto.category(),
                dto.participantId(),
                dto.split(),
                dto.groupId(),
                LocalDateTime.now(),
                LocalDateTime.now());
        return new ExpenseDtoMapper().apply(expense);
    }

    private void validator(Object objectValidate, AnnotationType... annotations) {
        var validation = new ValidationFieldLogic(getInstancesByAnnotation(annotations));
        ValidationResult validate = validation.validate(objectValidate);
        List<BrokenField> brokenFields = validate.getBrokenFields();
        if (!brokenFields.isEmpty()) {
            throw new RequestValidationException(brokenFields.get(0));
        }
    }
}













