package application.services.account;

import application.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import application.repositories.AccountRepository;

import java.math.BigDecimal;

@Service
@Primary
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }


    @Override
    public void withdrawMoney(BigDecimal money, Long id) throws IllegalAccessException {
        if(!this.accountRepository.exists(id)){
            throw new IllegalAccessException("There is no account with provided ID");
        }

        Account acc = accountRepository.findOne(id);

        BigDecimal newBalance = acc.getBalance().subtract(money);

        acc.setBalance(newBalance);

        accountRepository.save(acc);
    }

    @Override
    public void transferMoney(BigDecimal money, Long id) throws IllegalAccessException {
        Account acc = accountRepository.findOne(id);

        if(acc == null){
            throw new IllegalAccessException("There is no account with provided ID");
        }

        if(acc.getUser() == null){
            throw new RuntimeException("No user present for this account");
        }

        if(money.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Money can not be negative");
        }

        BigDecimal newBalance = acc.getBalance().add(money);
        acc.setBalance(newBalance);
        accountRepository.save(acc);
    }
}
