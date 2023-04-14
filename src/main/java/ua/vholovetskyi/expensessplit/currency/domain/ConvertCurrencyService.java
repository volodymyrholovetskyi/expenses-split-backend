package ua.vholovetskyi.expensessplit.currency.domain;

import lombok.AllArgsConstructor;
import ua.vholovetskyi.expensessplit.currency.domain.dto.ExchangeRateDto;

import java.util.Map;

@AllArgsConstructor
public class ConvertCurrencyService {
    private final ConvertibleCurrency exchangeRate;
    public void publish(Map<String, Object> params) {
        ExchangeRateDto exchangeRate1 = exchangeRate.getExchangeRate(params);
        ExchangeRate apply = new ExchangeRateMapper().apply(exchangeRate1);
        System.out.println(apply);
    }
}
