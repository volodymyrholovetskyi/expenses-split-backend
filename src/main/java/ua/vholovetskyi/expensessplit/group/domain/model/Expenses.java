package ua.vholovetskyi.expensessplit.group.domain.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import ua.vholovetskyi.expensessplit.group.domain.model.vo.Money;
import ua.vholovetskyi.expensessplit.shared.jpa.BaseEntity;

@Entity
@Table(name = "expenses")
public class Expenses extends BaseEntity {

    @Embedded
    private Money amount;
    @ManyToOne
    private Group group;
}
