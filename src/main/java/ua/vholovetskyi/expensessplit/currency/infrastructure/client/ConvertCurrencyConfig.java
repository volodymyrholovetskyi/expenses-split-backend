package ua.vholovetskyi.expensessplit.currency.infrastructure.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConvertCurrencyConfig {

    @Bean
    @ConfigurationProperties("expense.split.currency")
    public ConnectConfigProperties getConnectProperties() {
        return new ConnectConfigProperties();
    }
    @Bean
    public ConvertCurrencyWebFlux getConvertCurrencyWebFlux(ConnectConfigProperties connectConfigProperties) {
        return new ConvertCurrencyWebFlux(connectConfigProperties);
    }
}
