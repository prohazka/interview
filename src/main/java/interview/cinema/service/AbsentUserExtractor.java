package interview.cinema.service;

import interview.cinema.dto.User;
import interview.cinema.repository.OrderRepository;
import interview.cinema.repository.UserRepository;

import java.time.Duration;
import java.util.List;

public abstract class AbsentUserExtractor {
    OrderRepository orderRepository = new OrderRepository();
    UserRepository userRepository = new UserRepository();

    public abstract List<User> getUsersAbsentForDuration(Duration duration);
}
