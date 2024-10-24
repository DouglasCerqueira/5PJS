package dev.gameheaven.GameHeaven;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/contas")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Map<String, Object> payload) {
        List<String> idGames = (List<String>) payload.get("idGames");

        Account account = accountService.createAccount((String) payload.get("username"), (String) payload.get("password"),
                (String) payload.get("email"), (String) payload.get("cpf"), (String) payload.get("phone"), idGames
        );

        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}/idGames")
    public ResponseEntity<Account> updateIdGames(@PathVariable String id, @RequestBody List<String> idGames) {
        Account updatedAccount = accountService.updateIdGames(id, idGames);
        if (updatedAccount != null) {
            return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
