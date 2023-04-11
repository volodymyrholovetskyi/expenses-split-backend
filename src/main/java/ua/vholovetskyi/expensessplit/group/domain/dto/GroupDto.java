package ua.vholovetskyi.expensessplit.group.domain.dto;

import ua.vholovetskyi.expensessplit.shared.validation.annotation.MinLength;
import ua.vholovetskyi.expensessplit.shared.validation.annotation.NotNull;
import ua.vholovetskyi.expensessplit.shared.validation.annotation.marker.CustomValidation;

@CustomValidation(name = "GroupDto")
public record GroupDto(@NotNull @MinLength(min = 3) String name) {

}
