package ua.vholovetskyi.expensessplit.groupexpense.domain;

import jakarta.persistence.*;
import lombok.Getter;
import ua.vholovetskyi.expensessplit.commons.jpa.BaseEntity;
import ua.vholovetskyi.expensessplit.groupexpense.domain.type.CurrencyType;
import ua.vholovetskyi.expensessplit.groupexpense.domain.type.StatusType;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Table(name = "group")
public class Group extends BaseEntity {
    private String groupName;

    @Enumerated(EnumType.STRING)
    private StatusType status;
    @Enumerated(EnumType.STRING)
    private CurrencyType currency;
    @OneToMany(mappedBy = "group")
    private Set<Expense> expenses = new HashSet<>();
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public Group() {
    }

    public Group(String groupName, StatusType status, CurrencyType currency, Set<Expense> expenses, LocalDateTime createAt, LocalDateTime updateAt) {
        this.groupName = groupName;
        this.status = status;
        this.currency = currency;
        this.expenses = expenses;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}
