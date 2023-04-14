package ua.vholovetskyi.expensessplit.currency.domain;

import java.util.Map;

public interface IExchangeRate {

    ExchangeRateDto getExchangeRate(Map<String, Object> queryParams);
}
