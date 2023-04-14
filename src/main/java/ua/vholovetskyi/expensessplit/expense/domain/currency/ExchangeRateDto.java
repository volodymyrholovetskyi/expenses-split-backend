package ua.vholovetskyi.expensessplit.expense.domain.currency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@ToString
public class ExchangeRateDto {
    private String from;
    private String to;
    private double amount;
    private double rate;
    private double result;


}

