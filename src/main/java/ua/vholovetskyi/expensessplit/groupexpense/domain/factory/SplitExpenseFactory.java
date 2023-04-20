package ua.vholovetskyi.expensessplit.groupexpense.domain.factory;

import ua.vholovetskyi.expensessplit.groupexpense.domain.Expense;
import ua.vholovetskyi.expensessplit.groupexpense.domain.dto.command.CreateExpenseCommand;

public interface SplitExpenseFactory {

    Expense createExpense(CreateExpenseCommand command);
}
