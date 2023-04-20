package ua.vholovetskyi.expensessplit.groupexpense.domain.dto.response;

import ua.vholovetskyi.expensessplit.commons.response.BaseResponse;
import ua.vholovetskyi.expensessplit.commons.validation.field.model.BrokenField;

public class CreateGroupResponse extends BaseResponse<BrokenField, Long> {

    public CreateGroupResponse(boolean success, BrokenField left, Long right) {
        super(success, left, right);
    }

    public static CreateGroupResponse success(Long groupId) {
        return new CreateGroupResponse(true, null, groupId);
    }

    public static CreateGroupResponse failure(BrokenField brokenField) {
        return new CreateGroupResponse(false, brokenField, null);
    }
}
