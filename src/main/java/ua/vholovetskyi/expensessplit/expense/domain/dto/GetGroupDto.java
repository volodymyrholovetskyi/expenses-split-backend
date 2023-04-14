package ua.vholovetskyi.expensessplit.expense.domain.dto;

import ua.vholovetskyi.expensessplit.expense.domain.model.type.CurrencyType;
import ua.vholovetskyi.expensessplit.expense.domain.model.type.StatusType;

import java.time.LocalDateTime;

public record GetGroupDto(
        String name,
        StatusType status,
        CurrencyType currencyCode,
        LocalDateTime createAt,
        LocalDateTime updateAt
) {
}
