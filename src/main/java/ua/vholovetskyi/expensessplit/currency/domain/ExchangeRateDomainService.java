package ua.vholovetskyi.expensessplit.currency.domain;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class ExchangeRateDomainService {
    private final IExchangeRate exchangeRate;
    public void publish(Map<String, Object> params) {
        ExchangeRateDto exchangeRate1 = exchangeRate.getExchangeRate(params);
        ExchangeRate apply = new ExchangeRateMapper().apply(exchangeRate1);
        System.out.println(apply);
    }
}
