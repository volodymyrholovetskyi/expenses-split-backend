package ua.vholovetskyi.expensessplit.group.domain.currency.type;

public enum CurrencyType {

    PLN("PLN", "zł"),
    EUR("EUR", "€"),
    USD("USD", "$"),
    UAN("UAN", "₴");

    private String currencyCode;
    private String symbol;

    CurrencyType(String currencyCode, String symbol) {
        this.currencyCode = currencyCode;
        this.symbol = symbol;
    }
}