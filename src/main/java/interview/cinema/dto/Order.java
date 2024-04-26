package interview.cinema.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Order {
    int id;
    int userId;
    List<Ticket> tickets;
    Instant date;
}
