package interview.cinema.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Duration;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Movie {
    int id;
    String title;
    Duration duration;
}
