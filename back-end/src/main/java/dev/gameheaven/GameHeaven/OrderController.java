package dev.gameheaven.GameHeaven;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pedidos")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Map<String, Object> payload) {
        ObjectId accountID = new ObjectId((String) payload.get("accountID"));
        List<String> gameID = (List<String>) payload.get("gameID");
        String orderPrice = (String) payload.get("orderPrice");
        String statusCheck = (String) payload.get("status");

        int status = 0;
        if (statusCheck != null) {
            status = Integer.parseInt(statusCheck);
        }

        Order order = orderService.createOrder(accountID, gameID, orderPrice, status);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @GetMapping("/{accountID}")
    public ResponseEntity<List<Order>> getAllOrders(@PathVariable ObjectId accountID) {
        List<Order> orders = orderService.getAllOrdersById(accountID);
        if (orders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

}
