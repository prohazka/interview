package interview.cinema.repository;

import interview.cinema.dto.Order;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class OrderRepository {
    public List<Order> getAllOrders() {
        Order order1 = new Order(1, 0, null, Instant.now().minus(365, ChronoUnit.DAYS));
        Order order2 = new Order(2, 0, null, Instant.now().minus(365, ChronoUnit.DAYS));
        Order order3 = new Order(3, 1, null, Instant.now().minus(1, ChronoUnit.SECONDS));
        Order order4 = new Order(4, 1, null, Instant.now().minus(365, ChronoUnit.DAYS));
        Order order5 = new Order(5, 2, null, Instant.now().minus(1, ChronoUnit.SECONDS));
        Order order6 = new Order(6, 2, null, Instant.now().minus(1, ChronoUnit.SECONDS));
        return List.of(order1, order2, order3, order4, order5, order6);
    }

}
