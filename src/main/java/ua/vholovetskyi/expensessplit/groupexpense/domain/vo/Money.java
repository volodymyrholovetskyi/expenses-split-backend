package ua.vholovetskyi.expensessplit.groupexpense.domain.vo;

import ua.vholovetskyi.expensessplit.common.exception.IncorrectFormatMoneyException;
import ua.vholovetskyi.expensessplit.groupexpense.domain.type.CurrencyType;

import java.math.BigDecimal;

public class Money {
    private final BigDecimal amount;
    private final Currency currency;

    private Money(BigDecimal amount, Currency currency) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IncorrectFormatMoneyException(String.valueOf(amount));
        }
        this.amount = amount;
        this.currency = currency;
    }
    public static Money create(BigDecimal amount, CurrencyType currency) {
        return new Money(amount, Currency.create(currency));
    }
}