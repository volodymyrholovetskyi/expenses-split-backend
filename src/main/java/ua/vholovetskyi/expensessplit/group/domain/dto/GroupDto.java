package ua.vholovetskyi.expensessplit.group.domain.dto;

import ua.vholovetskyi.expensessplit.shared.validation.annotation.Required;
import ua.vholovetskyi.expensessplit.shared.validation.annotation.marker.CustomValidation;

@CustomValidation
public record GroupDto(@Required String name) {

}
