import exception.InvalidHandException;
import model.Card;
import model.Hand;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class HandTest {

    @Test
    void constructor_shouldThrow_whenHandSizeIsNotSeven() {
        assertThrows(InvalidHandException.class, () ->
                new Hand(List.of(
                        new Card("M7"), new Card("Z8"), new Card("P9")
                ))
        );
    }
}