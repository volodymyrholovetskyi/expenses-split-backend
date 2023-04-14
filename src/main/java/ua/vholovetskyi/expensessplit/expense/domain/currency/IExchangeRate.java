package ua.vholovetskyi.expensessplit.expense.domain.currency;

import java.util.Map;

public interface IExchangeRate {

    ExchangeRateDto getExchangeRate(Map<String, Object> queryParams);
}
