package ua.vholovetskyi.expensessplit.expense.domain.dto;

import ua.vholovetskyi.expensessplit.common.validation.annotation.MinLength;
import ua.vholovetskyi.expensessplit.common.validation.annotation.marker.CustomValidation;
import ua.vholovetskyi.expensessplit.expense.domain.currency.model.CurrencyType;

@CustomValidation(name = "GroupDto")
public record CreateGroupDto(
        @MinLength(min = 3)
        String name,
        CurrencyType currency
) {

}
