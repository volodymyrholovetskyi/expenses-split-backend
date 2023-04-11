package ua.vholovetskyi.expensessplit.shared.exception;

public class IncorrectFormatMoneyException extends BusinessException {
    public IncorrectFormatMoneyException(String amount) {
        super("Money cannot be: %s".formatted(amount));
    }
}
