package ua.vholovetskyi.expensessplit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.vholovetskyi.expensessplit.group.domain.GroupFactory;
import ua.vholovetskyi.expensessplit.group.domain.dto.GroupDto;

@SpringBootApplication
public class ExpensesSplitBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExpensesSplitBackendApplication.class, args);
        GroupFactory factory = new GroupFactory();
        factory.createGroup(new GroupDto(null));
    }

}
