package interview.cinema.repository;

import interview.cinema.dto.User;

import java.util.List;

public class UserRepository {
    public List<User> getAllUsers() {
        User user0 = new User(0, "Vitya");
        User user1 = new User(1, "Masha");
        User user2 = new User(2, "Sasha");
        return List.of(user0, user1, user2);
    }
}
