package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import application.services.account.AccountServiceImpl;
import application.services.user.UserServiceImpl;
import application.models.*;

import java.math.BigDecimal;
import java.util.Collections;

@SpringBootApplication
@Component
public class ConsoleRunner implements CommandLineRunner {

    private UserServiceImpl userService;
    private AccountServiceImpl accountService;

    @Autowired
    public ConsoleRunner(UserServiceImpl userService, AccountServiceImpl accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void run(String... strings) throws Exception {
        User user = new User();

        user.setAge(21);
        user.setUsername("example2");

        Account account = new Account();
        account.setBalance(new BigDecimal(25000));

        account.setUser(user);
        user.setAccounts(Collections.singletonList(account));

        userService.registerUser(user);

//        accountService.withdrawMoney(new BigDecimal(20000),2L);
 //       accountService.transferMoney(new BigDecimal(20000),1L);
    }
}
