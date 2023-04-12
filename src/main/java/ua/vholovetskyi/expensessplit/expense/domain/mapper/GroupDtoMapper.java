package ua.vholovetskyi.expensessplit.expense.domain.mapper;

import ua.vholovetskyi.expensessplit.expense.domain.dto.GetGroupDto;
import ua.vholovetskyi.expensessplit.expense.domain.model.Group;

import java.util.function.Function;

public class GroupDtoMapper implements Function<Group, GetGroupDto> {
    @Override
    public GetGroupDto apply(Group group) {
        return new GetGroupDto(
                group.getName(),
                group.getStatus(),
                group.getCurrency(),
                group.getCreateAt(),
                group.getUpdateAt()
        );
    }
}
