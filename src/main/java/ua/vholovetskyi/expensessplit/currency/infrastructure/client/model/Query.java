package ua.vholovetskyi.expensessplit.currency.infrastructure.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Query {
    private String to;
    private String from;
    private double amount;
}
