package dev.gameheaven.GameHeaven;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.bson.types.ObjectId;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/pedidos")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Map<String, String> payload) {
        ObjectId accountId = new ObjectId(payload.get("accountID"));
        ObjectId gameId = new ObjectId(payload.get("gameID"));
        String orderPrice = payload.get("orderPrice");
        String statusCheck = payload.get("status");

        int status = 0;
        if (statusCheck != null) {
            status = Integer.parseInt(statusCheck);
        }

        Order order = orderService.createOrder(accountId, gameId, orderPrice, status);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
}
