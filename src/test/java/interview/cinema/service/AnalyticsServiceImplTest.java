package interview.cinema.service;

import interview.cinema.dto.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

class AnalyticsServiceImplTest {
    @Test
    public void shouldSelectCorrecly() {
        List<User> usersAbsentForDuration = new AnalyticsServiceImpl().getUsersAbsentForDuration(Duration.ofDays(180));
        Assertions.assertEquals(1, usersAbsentForDuration.size());
        Assertions.assertEquals(0, usersAbsentForDuration.get(0).getId());
    }

}