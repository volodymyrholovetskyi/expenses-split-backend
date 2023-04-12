package ua.vholovetskyi.expensessplit.expense.application;

import org.springframework.stereotype.Service;
import ua.vholovetskyi.expensessplit.expense.domain.model.GroupFactory;

@Service
public class GroupApplicationService {

    private final GroupFactory groupFactory;

    public GroupApplicationService() {
        groupFactory = new GroupFactory();
    }

}
