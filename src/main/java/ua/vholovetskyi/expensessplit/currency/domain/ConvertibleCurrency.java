package ua.vholovetskyi.expensessplit.currency.domain;

import ua.vholovetskyi.expensessplit.currency.domain.dto.ExchangeRateDto;

import java.util.Map;

public interface ConvertibleCurrency {

    ExchangeRateDto getExchangeRate(Map<String, Object> queryParams);
}
