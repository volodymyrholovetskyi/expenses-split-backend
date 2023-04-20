package ua.vholovetskyi.expensessplit.groupexpense.domain.dto.command;

import ua.vholovetskyi.expensessplit.commons.validation.annotation.MinLength;
import ua.vholovetskyi.expensessplit.commons.validation.annotation.marker.CustomValidation;
import ua.vholovetskyi.expensessplit.groupexpense.domain.type.CurrencyType;

@CustomValidation
public record CreateGroupCommand(
        @MinLength(min = 3)
        String name,
        CurrencyType currency
) {

}
