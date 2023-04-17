package ua.vholovetskyi.expensessplit.groupexpense.domain;

import ua.vholovetskyi.expensessplit.groupexpense.domain.dto.expense.GetExpenseDto;

import java.util.function.Function;

public class ExpenseDtoMapper implements Function<Expense, GetExpenseDto> {
    @Override
    public GetExpenseDto apply(Expense expense) {
        return ;
    }
}
