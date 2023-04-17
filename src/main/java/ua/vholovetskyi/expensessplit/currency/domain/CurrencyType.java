package ua.vholovetskyi.expensessplit.currency.domain;

enum CurrencyType {

    PLN("PLN", "zł"),
    EUR("EUR", "€"),
    USD("USD", "$"),
    UAH("UAH", "₴");

    private String currencyCode;
    private String symbol;

    CurrencyType(String currencyCode, String symbol) {
        this.currencyCode = currencyCode;
        this.symbol = symbol;
    }
}