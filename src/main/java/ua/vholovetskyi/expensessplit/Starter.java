package ua.vholovetskyi.expensessplit;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ua.vholovetskyi.expensessplit.currency.domain.ConvertCurrencyService;
import ua.vholovetskyi.expensessplit.expense.domain.model.type.CurrencyType;
import ua.vholovetskyi.expensessplit.expense.domain.dto.CreateGroupDto;
import ua.vholovetskyi.expensessplit.expense.domain.dto.GetGroupDto;
import ua.vholovetskyi.expensessplit.expense.domain.model.GroupFactory;

import java.util.HashMap;
import java.util.Map;

@Component
@AllArgsConstructor
public class Starter implements CommandLineRunner {

    private final ConvertCurrencyService currencyService;
    @Override
    public void run(String... args) throws Exception {
        GroupFactory factory = new GroupFactory();
        GetGroupDto test = factory.createGroup(new CreateGroupDto("Test", CurrencyType.EUR));
        GetGroupDto test1 = factory.createGroup(new CreateGroupDto("Test", CurrencyType.EUR));
        System.out.println(test);
        System.out.println(test1);
        Map<String, Object> p = new HashMap<>();
        p.put("to", "UAH");
        p.put("from", "USD");
        p.put("amount", 1);
        currencyService.publish(p);
    }
}
