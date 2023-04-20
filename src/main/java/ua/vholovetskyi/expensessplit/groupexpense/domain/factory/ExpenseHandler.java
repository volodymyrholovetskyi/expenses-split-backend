package ua.vholovetskyi.expensessplit.groupexpense.domain.factory;

import ua.vholovetskyi.expensessplit.groupexpense.domain.type.SplitType;

import java.util.HashMap;
import java.util.Map;

public class ExpenseHandler {

    private final Map<SplitType, SplitExpenseFactory> expenses;

    public ExpenseHandler(){
        this.expenses = new HashMap<>();
        expenses.put(SplitType.SPLIT_EQUAL, new SplitEqualExpense());
        expenses.put(SplitType.SPLIT_UNEQUAL, new SplitEqualExpense());
        expenses.put(SplitType.SPLIT_PERCENT, new SplitEqualExpense());
    }

    public void addExpense(SplitType type, SplitExpenseFactory splitExpenseFactory) {
        expenses.put(type, splitExpenseFactory);
    }

    public SplitExpenseFactory getExpense(SplitType splitType) {
        return expenses.get(splitType);
    }
}
