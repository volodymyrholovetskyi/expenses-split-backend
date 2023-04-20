package ua.vholovetskyi.expensessplit.commons.validation;

import ua.vholovetskyi.expensessplit.commons.validation.field.model.BrokenField;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidationResult {

    List<BrokenField> brokenFields = new ArrayList<>();

    public void addBrokenField(List<BrokenField> brokenFields) {
        this.brokenFields.addAll(Collections.unmodifiableList(brokenFields));
    }

    public List<BrokenField> getBrokenFields() {
        return Collections.unmodifiableList(brokenFields);
    }
}
