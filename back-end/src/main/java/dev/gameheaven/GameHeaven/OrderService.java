package dev.gameheaven.GameHeaven;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(ObjectId accountId, ObjectId gameId, String orderPrice, int status) {
        Order order = new Order();
        order.setAccountID(accountId);
        order.setGameID(gameId);
        order.setOrderDate(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        order.setOrderTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        order.setOrderPrice(orderPrice);
        order.setStatus(status);

        return orderRepository.insert(order);
    }
}
