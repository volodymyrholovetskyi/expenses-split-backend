package ua.vholovetskyi.expensessplit.group.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import ua.vholovetskyi.expensessplit.shared.jpa.BaseAggregateRoot;

import java.time.LocalDateTime;

@Builder
@Entity
@Getter
@Table(name = "group")
public class Group extends BaseAggregateRoot {

    private String name;
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
