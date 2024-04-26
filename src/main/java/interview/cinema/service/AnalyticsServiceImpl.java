package interview.cinema.service;

import interview.cinema.dto.Order;
import interview.cinema.dto.User;
import jakarta.annotation.Nonnull;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AnalyticsServiceImpl extends AnalyticsService {

    public List<User> getUsersAbsentForDuration(Duration duration) {
        Instant thresholdDate = Instant.now().minus(duration);
        List<Order> allOrders = orderRepository.getAllOrders();
        List<User> allUsers = userRepository.getAllUsers();
        return allUsers.stream()
                .filter(user -> userHasNoOrderAfterDate(user.getId(), thresholdDate, allOrders)).collect(Collectors.toList());
    }

    private boolean userHasNoOrderAfterDate(int userId, @Nonnull Instant thresholdDate, List<Order> allOrders) {
        return allOrders.stream()
                .filter(order -> thresholdDate.isBefore(order.getDate()))
                .filter(order -> Objects.equals(order.getUserId(), userId))
                .findAny().isEmpty();
    }
}
