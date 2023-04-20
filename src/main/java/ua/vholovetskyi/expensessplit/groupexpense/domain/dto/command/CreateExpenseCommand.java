package ua.vholovetskyi.expensessplit.groupexpense.domain.dto.command;

import ua.vholovetskyi.expensessplit.commons.validation.annotation.marker.CustomValidation;
import ua.vholovetskyi.expensessplit.groupexpense.domain.type.CurrencyType;
import ua.vholovetskyi.expensessplit.groupexpense.domain.type.SplitType;
import ua.vholovetskyi.expensessplit.groupexpense.domain.vo.SplitUnequalExpense;

import java.math.BigDecimal;
import java.util.Set;

@CustomValidation
public record CreateExpenseCommand(
        String transaction,
        BigDecimal amount,
        String category,
        Long participantId,
        Set<SplitUnequalExpense> splitExpenses,
        SplitType split,
        CurrencyType currency,
        Long groupId
) {
}
