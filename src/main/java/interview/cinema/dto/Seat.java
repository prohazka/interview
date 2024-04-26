package interview.cinema.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Seat {
    int id;
    Hall hall;
    int row;
    int number;
}
