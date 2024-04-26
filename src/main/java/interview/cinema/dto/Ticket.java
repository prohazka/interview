package interview.cinema.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ticket {
    int id;
    Order order;
    BigDecimal price;
}
