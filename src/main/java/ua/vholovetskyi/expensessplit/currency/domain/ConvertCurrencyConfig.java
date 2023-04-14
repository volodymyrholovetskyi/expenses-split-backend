package ua.vholovetskyi.expensessplit.currency.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConvertCurrencyConfig {

    @Bean
    public ConvertCurrencyService exchangeRateDomainService(ConvertibleCurrency currency) {
        return new ConvertCurrencyService(currency);
    }
}
