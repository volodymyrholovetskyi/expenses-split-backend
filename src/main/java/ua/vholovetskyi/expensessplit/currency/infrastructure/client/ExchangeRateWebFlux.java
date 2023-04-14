package ua.vholovetskyi.expensessplit.currency.infrastructure.client;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;
import ua.vholovetskyi.expensessplit.currency.domain.ExchangeRateDto;
import ua.vholovetskyi.expensessplit.currency.domain.IExchangeRate;
import ua.vholovetskyi.expensessplit.currency.infrastructure.client.model.ExchangeRateRequest;

import java.util.Map;
import java.util.Objects;

@Component
@NoArgsConstructor
public class ExchangeRateWebFlux implements IExchangeRate {
    @Override
    public ExchangeRateDto getExchangeRate(Map<String, Object> queryParams) {

        String baseUri = "https://api.apilayer.com/exchangerates_data/convert";
        var builder = UriComponentsBuilder.fromUriString(baseUri).queryParams(parsParam(queryParams));

        return WebClient.builder()
                .defaultHeader("apikey", "")
                .uriBuilderFactory(new DefaultUriBuilderFactory(builder))
                .build()
                .get()
                .retrieve()
                .bodyToMono(ExchangeRateRequest.class)
                .map(ExchangeRateRequest::toDto)
                .block();
    }

    public MultiValueMap<String, String> parsParam(Map<String, Object> queryParams) {
        if (Objects.isNull(queryParams) || queryParams.size() < 3) {
            throw new IllegalArgumentException("The query is null or the parameters are not enough!");
        }
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>(queryParams.size());

        for (Map.Entry<String, Object> param : queryParams.entrySet()) {
            var key = param.getKey();
            var value = param.getValue();
            if ("to".equals(key) || "from".equals(key) || "amount".equals(key)) {
                params.add(key, String.valueOf(value));
            }
        }
        return params;
    }
}
