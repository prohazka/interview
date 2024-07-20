package interview.cinema.service;

import interview.cinema.dto.User;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class AbsentUserExtractorImpl extends AbsentUserExtractor {

    public List<User> getUsersAbsentForDuration(Duration duration) {
        return Collections.emptyList();
    }
}
