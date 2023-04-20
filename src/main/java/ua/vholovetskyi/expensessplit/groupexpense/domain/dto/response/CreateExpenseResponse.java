package ua.vholovetskyi.expensessplit.groupexpense.domain.dto.response;

import ua.vholovetskyi.expensessplit.commons.response.BaseResponse;
import ua.vholovetskyi.expensessplit.commons.validation.field.model.BrokenField;

public class CreateExpenseResponse extends BaseResponse<BrokenField, Long> {
    public CreateExpenseResponse(boolean success, BrokenField left, Long right) {
        super(success, left, right);
    }

    public static CreateExpenseResponse success(Long expenseId) {
        return new CreateExpenseResponse(true, null, expenseId);
    }

    public static CreateExpenseResponse failure(BrokenField brokenField) {
        return new CreateExpenseResponse(false, brokenField, null);
    }
}
