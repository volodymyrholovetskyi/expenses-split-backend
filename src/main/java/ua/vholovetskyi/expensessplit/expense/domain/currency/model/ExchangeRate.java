package ua.vholovetskyi.expensessplit.expense.domain.currency.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@ToString
public class ExchangeRate {

    private CurrencyType from;
    private CurrencyType to;
    private BigDecimal amount;
    BigDecimal rate;
    BigDecimal result;

}
