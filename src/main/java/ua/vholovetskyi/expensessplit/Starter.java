package ua.vholovetskyi.expensessplit;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ua.vholovetskyi.expensessplit.currency.domain.ConvertCurrencyFacade;
import ua.vholovetskyi.expensessplit.groupexpense.domain.type.CurrencyType;
import ua.vholovetskyi.expensessplit.groupexpense.domain.dto.group.CreateGroupDto;
import ua.vholovetskyi.expensessplit.groupexpense.domain.dto.group.GetGroupDto;
import ua.vholovetskyi.expensessplit.groupexpense.domain.GroupExpenseFactory;

import java.util.HashMap;
import java.util.Map;

@Component
@AllArgsConstructor
public class Starter implements CommandLineRunner {

    private final ConvertCurrencyFacade currencyService;


    @Override
    public void run(String... args) throws Exception {
        GroupExpenseFactory factory = new GroupExpenseFactory();
        GetGroupDto test = factory.createGroup(new CreateGroupDto("Test", CurrencyType.EUR));
        GetGroupDto test1 = factory.createGroup(new CreateGroupDto("Test", CurrencyType.EUR));
        System.out.println(test);
        System.out.println(test1);
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("to", "UAH");
        queryParams.put("from", "USD");
        queryParams.put("amount", 1);
//        currencyService.getExchangeRate(queryParams);
    }
}
