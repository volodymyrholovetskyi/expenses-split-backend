package ua.vholovetskyi.expensessplit.groupexpense.domain.type;

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
}