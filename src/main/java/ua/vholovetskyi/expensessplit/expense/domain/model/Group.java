package ua.vholovetskyi.expensessplit.expense.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import ua.vholovetskyi.expensessplit.common.jpa.BaseEntity;
import ua.vholovetskyi.expensessplit.expense.domain.currency.model.CurrencyType;
import ua.vholovetskyi.expensessplit.expense.domain.model.type.StatusType;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Table(name = "group")
public class Group extends BaseEntity {
    private String name;
    @Enumerated(EnumType.STRING)
    private CurrencyType currency;
    @OneToMany(mappedBy = "group")
    private Set<Expense> expenses = new HashSet<>();
    @Enumerated(EnumType.STRING)
    private StatusType status;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public Group() {
    }

    public Group(String name, StatusType status, CurrencyType currency, LocalDateTime createAt, LocalDateTime updateAt) {
        this.name = name;
        this.status = status;
        this.currency = currency;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}
