package ua.vholovetskyi.expensessplit.commons.exception;

public class CurrencyParseStringException extends BusinessException {

    public CurrencyParseStringException(String currency) {
        super("Currency: %s not supported".formatted(currency));
    }
}
