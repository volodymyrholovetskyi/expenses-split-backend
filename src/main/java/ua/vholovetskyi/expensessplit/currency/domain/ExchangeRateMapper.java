package ua.vholovetskyi.expensessplit.currency.domain;

import ua.vholovetskyi.expensessplit.currency.domain.dto.ExchangeRateDto;

import java.util.function.Function;

class ExchangeRateMapper implements Function<ExchangeRateDto, ExchangeRate> {
    @Override
    public ExchangeRate apply(ExchangeRateDto exchangeRateDto) {
        return new ExchangeRate(
                exchangeRateDto.getFrom(),
                exchangeRateDto.getTo(),
                exchangeRateDto.getAmount(),
                exchangeRateDto.getRate(),
                exchangeRateDto.getResult());
    }
}