package ua.vholovetskyi.expensessplit.groupexpense.application;

import org.springframework.stereotype.Service;
import ua.vholovetskyi.expensessplit.groupexpense.domain.GroupExpenseFacade;

@Service
public class GroupApplicationService {

    private final GroupExpenseFacade groupExpenseFacade;

    public GroupApplicationService() {
        groupExpenseFacade = new GroupExpenseFacade();
    }

}
