package ua.vholovetskyi.expensessplit.groupexpense.domain.dto.expense;

import ua.vholovetskyi.expensessplit.common.validation.annotation.marker.CustomValidation;
import ua.vholovetskyi.expensessplit.groupexpense.domain.type.CurrencyType;
import ua.vholovetskyi.expensessplit.groupexpense.domain.type.SplitType;

import java.math.BigDecimal;

@CustomValidation(name = "CreateExpenseDto")
public record CreateExpenseDto(
        String transaction,
        BigDecimal amount,
        String category,
        Long participantId,
        SplitType split,
        CurrencyType currency,
        Long groupId
) {


}
