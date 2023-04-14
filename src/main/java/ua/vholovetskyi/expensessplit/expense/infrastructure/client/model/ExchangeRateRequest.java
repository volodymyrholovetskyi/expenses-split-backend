package ua.vholovetskyi.expensessplit.expense.infrastructure.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ua.vholovetskyi.expensessplit.expense.domain.currency.ExchangeRateDto;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ExchangeRateRequest {
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

