package ua.vholovetskyi.expensessplit.groupexpense.domain.vo;

import ua.vholovetskyi.expensessplit.groupexpense.domain.type.CurrencyType;

import java.math.BigDecimal;

public class Money {
    private final BigDecimal amount;
    private String currencyCode;

    private static final Currency DEFAULT_CURRENCY = Currency.getInstance("EUR");

    private static final BigDecimal HUNDRED = BigDecimal.valueOf(100.0);
    private static final Money ZERO = new Money(BigDecimal.ZERO, DEFAULT_CURRENCY);

    private Money(BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currencyCode = currency.getCurrencyCode();
    }

    public static Money forAmount(BigDecimal amount, CurrencyType currency) {
        if (amount != null && amount.compareTo(BigDecimal.ZERO) > 0) {
            return new Money(amount, Currency.create(currency));
        }
        return ZERO;
    }

    public static Money forPercent(BigDecimal amount, CurrencyType currency) {
        if (amount != null
                && amount.compareTo(BigDecimal.ZERO) > 0
                && amount.compareTo(HUNDRED) < 0) {
            return new Money(amount, Currency.create(currency));
        }
        return ZERO;
    }
}
