package ua.vholovetskyi.expensessplit.commons.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Function;

@Getter
@AllArgsConstructor
public class BaseResponse <L, R> {

    private boolean success;

    private L left;

    private R right;

    public <T> T handle(Function<R, T> onSuccess, Function<L, T> onError) {
        if (success) {
            return onSuccess.apply(right);
        } else {
            return onError.apply(left);
        }
    }
}
