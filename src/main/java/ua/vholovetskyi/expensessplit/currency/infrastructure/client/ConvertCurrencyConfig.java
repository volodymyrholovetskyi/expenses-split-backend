package ua.vholovetskyi.expensessplit.currency.infrastructure.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConvertCurrencyConfig {

    @Bean
    @ConfigurationProperties("expense.split.currency")
    public ConnectProperties getConnectProperties() {
        return new ConnectProperties();
    }
    @Bean
    public ConvertCurrencyWebFlux getConvertCurrencyWebFlux(ConnectProperties connectProperties) {
        return new ConvertCurrencyWebFlux(connectProperties);
    }
}
