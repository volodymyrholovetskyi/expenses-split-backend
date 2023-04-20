package ua.vholovetskyi.expensessplit.groupexpense.domain.vo;

import ua.vholovetskyi.expensessplit.commons.exception.CurrencyParseStringException;
import ua.vholovetskyi.expensessplit.groupexpense.domain.type.CurrencyType;

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

    public static Currency getInstance(String currency) {
        Optional<CurrencyType> currencyType = CurrencyType.parseString(currency);
        if (currencyType.isEmpty()) {
            throw new CurrencyParseStringException(currency);
        }
        return new Currency(currencyType.get());
    }

    public String getCurrencyCode() {
        return currencyType.getCurrencyCode();
    }
}
