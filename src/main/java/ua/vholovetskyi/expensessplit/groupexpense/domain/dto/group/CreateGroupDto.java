package ua.vholovetskyi.expensessplit.groupexpense.domain.dto.group;

import ua.vholovetskyi.expensessplit.common.validation.annotation.MinLength;
import ua.vholovetskyi.expensessplit.common.validation.annotation.marker.CustomValidation;
import ua.vholovetskyi.expensessplit.groupexpense.domain.type.CurrencyType;

@CustomValidation(name = "GroupDto")
public record CreateGroupDto(
        @MinLength(min = 3)
        String name,
        CurrencyType currency
) {

}
