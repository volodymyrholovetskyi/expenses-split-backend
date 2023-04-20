package ua.vholovetskyi.expensessplit.currency.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
class ExchangeRate {
    private String fromCurrencyCode;
    private String toCurrencyCode;
    private double amount;
    private double rate;
    private double result;

}
