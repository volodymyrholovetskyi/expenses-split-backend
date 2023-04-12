package ua.vholovetskyi.expensessplit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.vholovetskyi.expensessplit.expense.domain.currency.type.CurrencyType;
import ua.vholovetskyi.expensessplit.expense.domain.dto.GetGroupDto;
import ua.vholovetskyi.expensessplit.expense.domain.model.GroupFactory;
import ua.vholovetskyi.expensessplit.expense.domain.dto.CreateGroupDto;

@SpringBootApplication
public class ExpensesSplitBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExpensesSplitBackendApplication.class, args);
        GroupFactory factory = new GroupFactory();
        GetGroupDto test = factory.createGroup(new CreateGroupDto("Test", CurrencyType.EUR));
        GetGroupDto test1 = factory.createGroup(new CreateGroupDto("Test", CurrencyType.EUR));
        System.out.println(test);
        System.out.println(test1);
    }
}
