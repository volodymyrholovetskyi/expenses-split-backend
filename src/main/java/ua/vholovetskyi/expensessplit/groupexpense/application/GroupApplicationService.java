package ua.vholovetskyi.expensessplit.groupexpense.application;

import org.springframework.stereotype.Service;
import ua.vholovetskyi.expensessplit.groupexpense.domain.GroupExpenseFactory;

@Service
public class GroupApplicationService {

    private final GroupExpenseFactory groupExpenseFactory;

    public GroupApplicationService() {
        groupExpenseFactory = new GroupExpenseFactory();
    }

}
