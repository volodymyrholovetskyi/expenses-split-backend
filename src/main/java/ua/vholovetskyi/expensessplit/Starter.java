package ua.vholovetskyi.expensessplit;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ua.vholovetskyi.expensessplit.expense.domain.model.type.CurrencyType;
import ua.vholovetskyi.expensessplit.expense.domain.dto.CreateGroupDto;
import ua.vholovetskyi.expensessplit.expense.domain.dto.GetGroupDto;
import ua.vholovetskyi.expensessplit.expense.domain.model.GroupFactory;
import ua.vholovetskyi.expensessplit.currency.infrastructure.client.ExchangeRateWebFlux;

import java.util.HashMap;
import java.util.Map;

@Component
@AllArgsConstructor
public class Starter implements CommandLineRunner {

    private final ExchangeRateWebFlux webFlux;
    @Override
    public void run(String... args) throws Exception {
        GroupFactory factory = new GroupFactory();
        GetGroupDto test = factory.createGroup(new CreateGroupDto("Test", CurrencyType.EUR));
        GetGroupDto test1 = factory.createGroup(new CreateGroupDto("Test", CurrencyType.EUR));
        System.out.println(test);
        System.out.println(test1);
        Map<String, Object> p = new HashMap<>();
        p.put("to", "USD");
        p.put("from", "EUR");
        p.put("amount", 5);
//        ExchangeRateDomainService service = new ExchangeRateDomainService(webFlux);

//        service.publish(p);
    }
}
