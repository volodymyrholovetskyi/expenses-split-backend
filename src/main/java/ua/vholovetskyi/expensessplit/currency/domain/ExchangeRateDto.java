package ua.vholovetskyi.expensessplit.currency.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

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

