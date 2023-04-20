package ua.vholovetskyi.expensessplit;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ua.vholovetskyi.expensessplit.currency.domain.ConvertCurrencyFacade;
import ua.vholovetskyi.expensessplit.groupexpense.domain.dto.response.CreateGroupResponse;
import ua.vholovetskyi.expensessplit.groupexpense.domain.type.CurrencyType;
import ua.vholovetskyi.expensessplit.groupexpense.domain.dto.command.CreateGroupCommand;
import ua.vholovetskyi.expensessplit.groupexpense.domain.GroupExpenseFacade;

import java.util.HashMap;
import java.util.Map;

@Component
@AllArgsConstructor
public class Starter implements CommandLineRunner {

    private final ConvertCurrencyFacade currencyService;


    @Override
    public void run(String... args) throws Exception {
        GroupExpenseFacade factory = new GroupExpenseFacade();
        CreateGroupResponse test = factory.createGroup(new CreateGroupCommand("Test", CurrencyType.EUR));
        CreateGroupResponse test1 = factory.createGroup(new CreateGroupCommand("Test", CurrencyType.EUR));
        System.out.println(test);
        System.out.println(test1);
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("to", "UAH");
        queryParams.put("from", "USD");
        queryParams.put("amount", 1);
//        currencyService.getExchangeRate(queryParams);
    }
}
