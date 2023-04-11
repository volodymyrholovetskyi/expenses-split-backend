package ua.vholovetskyi.expensessplit.group.application;

import org.springframework.stereotype.Service;
import ua.vholovetskyi.expensessplit.group.domain.GroupFactory;

@Service
public class GroupApplicationService {

    private final GroupFactory groupFactory;
    public GroupApplicationService() {
        groupFactory = new GroupFactory();
    }
}
