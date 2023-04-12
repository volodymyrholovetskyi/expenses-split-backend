package ua.vholovetskyi.expensessplit.common.exception;

public class CurrencyNotSupportedException extends BusinessException {

    public CurrencyNotSupportedException(String currency) {
        super("Currency: %s not supported".formatted(currency));
    }
}
