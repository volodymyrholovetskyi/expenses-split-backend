package ua.vholovetskyi.expensessplit.groupexpense.domain;

import ua.vholovetskyi.expensessplit.groupexpense.domain.dto.group.GetGroupDto;

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
