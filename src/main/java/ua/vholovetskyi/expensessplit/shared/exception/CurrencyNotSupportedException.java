package ua.vholovetskyi.expensessplit.shared.exception;

public class CurrencyNotSupportedException extends BusinessException {

    public CurrencyNotSupportedException(String currency) {
        super("Currency: %s not supported".formatted(currency));
    }
}
