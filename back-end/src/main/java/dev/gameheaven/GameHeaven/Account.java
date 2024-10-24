package dev.gameheaven.GameHeaven;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "contas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    private ObjectId id;
    private String username;
    private String password;
    private String email;
    private String CPF;
    private String phone;
    private List<String> idGames;

    public Account(String username, String password, String email, String CPF, String phone, List<String> idGames) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.CPF = CPF;
        this.phone = phone;
        this.idGames = idGames;
    }
}
