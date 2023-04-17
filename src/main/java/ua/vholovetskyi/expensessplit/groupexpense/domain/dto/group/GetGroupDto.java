package ua.vholovetskyi.expensessplit.groupexpense.domain.dto.group;

import ua.vholovetskyi.expensessplit.groupexpense.domain.type.CurrencyType;
import ua.vholovetskyi.expensessplit.groupexpense.domain.type.StatusType;

import java.time.LocalDateTime;

public record GetGroupDto(
        String name,
        StatusType status,
        CurrencyType currencyCode,
        LocalDateTime createAt,
        LocalDateTime updateAt
) {
}
