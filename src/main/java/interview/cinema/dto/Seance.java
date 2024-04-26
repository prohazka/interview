package interview.cinema.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Seance {
    int id;
    Movie movie;
    Instant date;
    Hall hall;
}
