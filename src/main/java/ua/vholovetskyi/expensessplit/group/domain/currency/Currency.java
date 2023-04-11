package ua.vholovetskyi.expensessplit.group.domain.currency;

import ua.vholovetskyi.expensessplit.group.domain.currency.type.CurrencyType;
import ua.vholovetskyi.expensessplit.shared.exception.CurrencyNotSupportedException;

import java.util.Arrays;
import java.util.Optional;

public class Currency {

    private final CurrencyType currencyType;

    private Currency(String currency) {
        this.currencyType = checkCorrectType(currency)
                .orElseThrow(() -> new CurrencyNotSupportedException(currency));
    }

    public static Currency create(String currency) {
        return new Currency(currency);
    }

    public Optional<CurrencyType> checkCorrectType(String currencyCode) {
        return Arrays.stream(CurrencyType.values())
                .filter(currency -> currency.name().equalsIgnoreCase(currencyCode))
                .findFirst();
    }
}
