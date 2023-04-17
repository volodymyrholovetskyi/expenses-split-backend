package ua.vholovetskyi.expensessplit.currency.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@ToString
class ExchangeRate {
    private CurrencyType from;
    private CurrencyType to;
    private BigDecimal amount;
    private BigDecimal rate;
    private BigDecimal result;

}
