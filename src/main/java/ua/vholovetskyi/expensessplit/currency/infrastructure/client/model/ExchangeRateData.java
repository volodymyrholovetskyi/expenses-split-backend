package ua.vholovetskyi.expensessplit.currency.infrastructure.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ua.vholovetskyi.expensessplit.currency.domain.dto.ExchangeRateDto;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ExchangeRateData {
    private boolean success;
    private Query query;
    private Info info;

    private double result;

    public ExchangeRateDto toDto() {
        return new ExchangeRateDto(
                query.getFrom(),
                query.getTo(),
                query.getAmount(),
                info.getRate(),
                result
        );
    }
}

