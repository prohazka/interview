package interview.cinema.service;

import interview.cinema.dto.Order;
import interview.cinema.dto.User;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AbsentUserExtractorImpl extends AbsentUserExtractor {

    public List<User> getUsersAbsentForDuration(Duration duration) {
        List result = new ArrayList<>();

        var users = userRepository.getAllUsers();
        var orders = orderRepository.getAllOrders();
        for (User user : users) {
            var lastUserOrder = orders.stream().filter(
                    x -> user.getId() == x.getUserId()).max(
                    Comparator.comparing(Order::getDate));
            if (lastUserOrder.isPresent()
                    && lastUserOrder.get().getDate().plus(duration).isBefore(new Date().toInstant())) {
                result.add(user);
            }
        }

        return result;
    }
}
