package ua.vholovetskyi.expensessplit.groupexpense.domain.factory;

import ua.vholovetskyi.expensessplit.groupexpense.domain.Expense;
import ua.vholovetskyi.expensessplit.groupexpense.domain.dto.command.CreateExpenseCommand;
import ua.vholovetskyi.expensessplit.groupexpense.domain.vo.Money;

import java.time.LocalDateTime;

public class SplitEqualExpense implements SplitExpenseFactory {
    @Override
    public Expense createExpense(CreateExpenseCommand command) {
        return new Expense(
                command.transaction(),
                Money.forAmount(command.amount(), command.currency()),
                command.category(),
                command.participantId(),
                command.split(),
                command.groupId(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }
}
