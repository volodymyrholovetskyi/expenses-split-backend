package ua.vholovetskyi.expensessplit.groupexpense.domain;

import lombok.extern.slf4j.Slf4j;
import ua.vholovetskyi.expensessplit.commons.validation.ValidationFieldLogic;
import ua.vholovetskyi.expensessplit.commons.validation.ValidationResult;
import ua.vholovetskyi.expensessplit.commons.validation.field.model.BrokenField;
import ua.vholovetskyi.expensessplit.groupexpense.domain.dto.command.CreateExpenseCommand;
import ua.vholovetskyi.expensessplit.groupexpense.domain.dto.command.CreateGroupCommand;
import ua.vholovetskyi.expensessplit.groupexpense.domain.dto.response.CreateExpenseResponse;
import ua.vholovetskyi.expensessplit.groupexpense.domain.dto.response.CreateGroupResponse;
import ua.vholovetskyi.expensessplit.groupexpense.domain.factory.ExpenseHandler;
import ua.vholovetskyi.expensessplit.groupexpense.domain.factory.SplitExpenseFactory;
import ua.vholovetskyi.expensessplit.groupexpense.domain.type.StatusType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

import static ua.vholovetskyi.expensessplit.commons.validation.field.type.AnnotationType.getInstancesByAnnotation;

@Slf4j
public class GroupExpenseFacade {
    public CreateGroupResponse createGroup(CreateGroupCommand command) {
        Optional<BrokenField> brokenField = validator(command);
        if (brokenField.isPresent()) {
            return CreateGroupResponse.failure(brokenField.get());
        }
        Group group = new GroupMapper().apply(command);
        return CreateGroupResponse.success(group.getId());
    }

    public CreateExpenseResponse addExpenseToGroup(CreateExpenseCommand command) {
        Optional<BrokenField> brokenField = validator(command);
        if (brokenField.isPresent()) {
            return CreateExpenseResponse.failure(brokenField.get());
        }
        SplitExpenseFactory splitExpenseFactory = new ExpenseHandler().getExpense(command.split());
        Expense expense = splitExpenseFactory.createExpense(command);
        return CreateExpenseResponse.success(expense.getId());
    }

    private Optional<BrokenField> validator(Object objectValidate) {
        var validation = new ValidationFieldLogic(getInstancesByAnnotation());
        ValidationResult validate = validation.validate(objectValidate);
        List<BrokenField> brokenFields = validate.getBrokenFields();
        return brokenFields.stream().findFirst();
    }

    static class GroupMapper implements Function<CreateGroupCommand, Group> {
        @Override
        public Group apply(CreateGroupCommand command) {
            return new Group(
                    command.name(),
                    StatusType.NEW,
                    command.currency(),
                    Set.of(),
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
        }
    }
}













