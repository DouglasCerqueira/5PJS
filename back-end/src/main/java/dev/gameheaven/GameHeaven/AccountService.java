package dev.gameheaven.GameHeaven;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Account createAccount(String username, String password, String email, String CPF, String phone, List<String> idGames) {
        Account account = new Account(username, password, email, CPF, phone, idGames);
        accountRepository.insert(account);

        return account;
    }

    public Account updateIdGames(String id, List<String> newIdGames) {
        Optional<Account> optionalAccount = accountRepository.findById(new ObjectId(id));
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            List<String> currentIdGames = account.getIdGames();

            for (String newIdGame : newIdGames) {
                if (!currentIdGames.contains(newIdGame)) {
                    currentIdGames.add(newIdGame);
                }
            }

            account.setIdGames(currentIdGames);
            return accountRepository.save(account);
        }
        return null;
    }
}

