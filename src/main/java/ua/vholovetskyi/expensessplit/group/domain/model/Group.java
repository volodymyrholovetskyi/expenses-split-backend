package ua.vholovetskyi.expensessplit.group.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import ua.vholovetskyi.expensessplit.group.domain.currency.type.CurrencyType;
import ua.vholovetskyi.expensessplit.shared.jpa.BaseEntity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Builder
@Entity
@Getter
@Table(name = "group")
public class Group extends BaseEntity {
    private String name;

    private CurrencyType settlementCurrencyType;

    @OneToMany
    private Set<Expenses> expenses = new HashSet<>();
    private StatusGroup status;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public Group() {
    }

    public Group(String name, StatusGroup status, LocalDateTime createAt, LocalDateTime updateAt) {
        this.name = name;
        this.status = status;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}
