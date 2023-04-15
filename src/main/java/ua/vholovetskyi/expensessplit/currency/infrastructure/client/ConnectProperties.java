package ua.vholovetskyi.expensessplit.currency.infrastructure.client;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
@NoArgsConstructor
@Getter
@Setter
public class ConnectProperties {
    private String baseUrl;
    private Map<String, String> headers = new HashMap<>();

}
