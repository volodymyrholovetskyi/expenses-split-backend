package ua.vholovetskyi.expensessplit.groupexpense.domain.vo;

import ua.vholovetskyi.expensessplit.groupexpense.domain.type.CurrencyType;

import java.util.Arrays;
import java.util.Optional;

public class Currency {
    private CurrencyType currencyType;

    private Currency(CurrencyType currency) {
        this.currencyType = currency;
    }

    protected Currency() {
    }

    public static Currency create(CurrencyType currency) {
        return new Currency(currency);
    }

    public Optional<CurrencyType> checkCorrectType(String currencyCode) {
        return Arrays.stream(CurrencyType.values())
                .filter(currency -> currency.name().equalsIgnoreCase(currencyCode))
                .findFirst();
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }
}
