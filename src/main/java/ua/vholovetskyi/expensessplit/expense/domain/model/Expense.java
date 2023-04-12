package ua.vholovetskyi.expensessplit.expense.domain.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import ua.vholovetskyi.expensessplit.expense.domain.model.vo.Money;
import ua.vholovetskyi.expensessplit.common.jpa.BaseEntity;

@Entity
@Table(name = "expense")
public class Expense extends BaseEntity {

    @Embedded
    private Money amount;
    @ManyToOne
    private Group group;
}
