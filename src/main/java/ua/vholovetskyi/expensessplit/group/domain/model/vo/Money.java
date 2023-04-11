package ua.vholovetskyi.expensessplit.group.domain.model.vo;

import ua.vholovetskyi.expensessplit.group.domain.currency.Currency;
import ua.vholovetskyi.expensessplit.shared.exception.IncorrectFormatMoneyException;

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
    public static Money create(BigDecimal amount, String currency) {
        return new Money(amount, Currency.create(currency));
    }
}
