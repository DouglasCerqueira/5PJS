package dev.gameheaven.GameHeaven;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "pedidos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    private ObjectId id;
    private ObjectId accountID;
    private List<String> gameID;
    private String orderDate;
    private String orderTime;
    private String orderPrice;
    private int status; //(0 = Aguardando Pagamento, 1 = Cancelado, 2 = Finalizado)
}
