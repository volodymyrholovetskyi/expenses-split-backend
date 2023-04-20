package ua.vholovetskyi.expensessplit.groupexpense.domain.type;

import java.util.Arrays;
import java.util.Optional;

public enum CurrencyType {

    PLN("PLN", "zł"),
    EUR("EUR", "€"),
    USD("USD", "$"),
    UAN("UAH", "₴");

    private String currencyCode;
    private String symbol;

    CurrencyType(String currencyCode, String symbol) {
        this.currencyCode = currencyCode;
        this.symbol = symbol;
    }

    public static Optional<CurrencyType> parseString(String currencyCode) {
        return Arrays.stream(CurrencyType.values())
                .filter(currency -> currency.name().equalsIgnoreCase(currencyCode))
                .findFirst();
    }

    public String getCurrencyCode() {
        return currencyCode;
    }
}