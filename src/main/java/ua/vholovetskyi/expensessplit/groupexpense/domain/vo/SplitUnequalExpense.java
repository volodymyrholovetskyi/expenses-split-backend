package ua.vholovetskyi.expensessplit.groupexpense.domain.vo;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class SplitUnequalExpense {

    private Long participantId;

    private BigDecimal amount;

    private SplitUnequalExpense(Long participantId, BigDecimal amount) {
        this.participantId = participantId;
        this.amount = amount;
    }
}
