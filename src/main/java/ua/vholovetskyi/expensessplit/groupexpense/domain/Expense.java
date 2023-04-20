package ua.vholovetskyi.expensessplit.groupexpense.domain;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import ua.vholovetskyi.expensessplit.groupexpense.domain.type.SplitType;
import ua.vholovetskyi.expensessplit.groupexpense.domain.vo.Money;
import ua.vholovetskyi.expensessplit.commons.jpa.BaseEntity;

import java.time.LocalDateTime;

@Entity
@Table(name = "expense")
@NoArgsConstructor
public class Expense extends BaseEntity {
    private String transaction;
    @Embedded
    private Money amount;
    private String category;
    @Enumerated(EnumType.STRING)
    private SplitType splitType;
    private Long participantId;
    private Long groupId;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public Expense(String transaction, Money amount, String category, Long participantId, SplitType splitType, Long groupId, LocalDateTime createAt, LocalDateTime updateAt) {
        this.transaction = transaction;
        this.amount = amount;
        this.category = category;
        this.participantId = participantId;
        this.splitType = splitType;
        this.groupId = groupId;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

}
