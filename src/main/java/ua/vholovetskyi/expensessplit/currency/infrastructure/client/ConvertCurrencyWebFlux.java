package ua.vholovetskyi.expensessplit.currency.infrastructure.client;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;
import ua.vholovetskyi.expensessplit.currency.domain.ConvertibleCurrency;
import ua.vholovetskyi.expensessplit.currency.domain.dto.ExchangeRateDto;
import ua.vholovetskyi.expensessplit.currency.infrastructure.client.model.ExchangeRateRequest;

import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

@AllArgsConstructor
public class ConvertCurrencyWebFlux implements ConvertibleCurrency {
    private final ConnectProperties connect;

    @Override
    public ExchangeRateDto getExchangeRate(Map<String, Object> queryParams) {
        var baseUli = UriComponentsBuilder
                .fromUriString(connect.getBaseUrl())
                .queryParams(parsQueryParam(queryParams));

        return WebClient.builder()
                .defaultHeaders(parsHeader(connect.getHeaders()))
                .uriBuilderFactory(new DefaultUriBuilderFactory(baseUli))
                .build()
                .get()
                .retrieve()
                .bodyToMono(ExchangeRateRequest.class)
                .map(ExchangeRateRequest::toDto)
                .block();
    }

    public MultiValueMap<String, String> parsQueryParam(Map<String, Object> queryParams) {
        if (Objects.isNull(queryParams) || queryParams.size() < 3) {
            throw new IllegalArgumentException("The query is null or the parameters are not enough!");
        }
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>(queryParams.size());
        for (Map.Entry<String, Object> param : queryParams.entrySet()) {
            var key = param.getKey();
            var value = param.getValue();
            if ("to".equals(key) || "from".equals(key) || "amount".equals(key)) {
                params.add(key, String.valueOf(value));
            } else {
                throw new IllegalArgumentException("Unexpected parameter!");
            }
        }
        return params;
    }

    public Consumer<HttpHeaders> parsHeader(Map<String, String> headers) {
        if (Objects.isNull(headers)) {
            throw new IllegalArgumentException("The header is null are not enough!");
        }
        Consumer<HttpHeaders> httpHeader = null;
        for (Map.Entry<String, String> header : headers.entrySet()) {
            String key = header.getKey();
            if ("apikey".equals(key)) {
                httpHeader = h -> h.add(key, header.getValue());
            } else {
                throw new IllegalArgumentException("Unexpected parameter!");
            }
        }
        return httpHeader;
    }
}
