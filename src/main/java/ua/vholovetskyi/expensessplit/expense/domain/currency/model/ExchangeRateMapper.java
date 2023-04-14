package ua.vholovetskyi.expensessplit.expense.domain.currency.model;

import ua.vholovetskyi.expensessplit.expense.domain.currency.ExchangeRateDto;

import java.math.BigDecimal;
import java.util.function.Function;

public class ExchangeRateMapper implements Function<ExchangeRateDto, ExchangeRate> {
    @Override
    public ExchangeRate apply(ExchangeRateDto exchangeRateDto) {
        return new ExchangeRate(
                CurrencyType.valueOf(exchangeRateDto.getFrom()),
                CurrencyType.valueOf(exchangeRateDto.getTo()),
                BigDecimal.valueOf(exchangeRateDto.getAmount()),
                BigDecimal.valueOf(exchangeRateDto.getRate()),
                BigDecimal.valueOf(exchangeRateDto.getResult())
        );
    }
}
