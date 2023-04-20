package ua.vholovetskyi.expensessplit.currency.domain;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ua.vholovetskyi.expensessplit.currency.domain.dto.ExchangeRateDto;

import java.util.Map;

@AllArgsConstructor
@Component
public class ConvertCurrencyFacade {
    private final ConvertibleCurrency currency;

    public ExchangeRate getCurrency(Map<String, Object> params) {
        ExchangeRateDto exchangeRate = currency.getExchangeRate(params);
        System.out.println(exchangeRate);
        return new ExchangeRateMapper().apply(exchangeRate);
    }
}
