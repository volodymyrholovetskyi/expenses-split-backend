package ua.vholovetskyi.expensessplit.currency.domain;

import ua.vholovetskyi.expensessplit.currency.domain.dto.ExchangeRateDto;
import ua.vholovetskyi.expensessplit.currency.domain.CurrencyType;
import ua.vholovetskyi.expensessplit.currency.domain.ExchangeRate;

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
