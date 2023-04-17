package ua.vholovetskyi.expensessplit.currency.domain;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ua.vholovetskyi.expensessplit.currency.domain.dto.ExchangeRateDto;

import java.util.Map;

@AllArgsConstructor
@Component
public class ConvertCurrencyFacade {
    private final ConvertibleCurrency exchangeRate;

    public void getExchangeRate(Map<String, Object> params) {
        ExchangeRateDto exchangeRate1 = exchangeRate.getExchangeRate(params);
        ExchangeRate apply = new ExchangeRateMapper().apply(exchangeRate1);
        System.out.println(apply);
    }
}
