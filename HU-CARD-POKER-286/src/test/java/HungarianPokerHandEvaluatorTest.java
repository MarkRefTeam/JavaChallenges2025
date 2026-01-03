import evaluator.HandType;
import evaluator.HungarianPokerHandEvaluator;
import model.Card;
import model.Hand;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HungarianPokerHandEvaluatorTest {

    private final HungarianPokerHandEvaluator evaluator = HungarianPokerHandEvaluator.getInstance();

    static Stream<Object[]> hands() {
        return Stream.of(
                new Object[]{ // FLUSH: 7 same colour (M)
                        new Hand(List.of(
                                new Card("M7"), new Card("M8"), new Card("M9"),
                                new Card("MT"), new Card("MA"), new Card("MF"), new Card("MK")
                        )),
                        HandType.FLUSH
                },
                new Object[]{ // POKER: 4 same value (7)
                        new Hand(List.of(
                                new Card("M7"), new Card("Z7"), new Card("P7"), new Card("T7"),
                                new Card("M8"), new Card("Z9"), new Card("PT")
                        )),
                        HandType.POKER
                },
                new Object[]{ // ALMOST_FLUSH: 4 same colour (Z)
                        new Hand(List.of(
                                new Card("Z7"), new Card("Z8"), new Card("Z9"), new Card("ZT"),
                                new Card("M7"), new Card("P8"), new Card("T9")
                        )),
                        HandType.ALMOST_FLUSH
                },
                new Object[]{ // NOTHING
                        new Hand(List.of(
                                new Card("M7"), new Card("Z8"), new Card("P9"),
                                new Card("TT"), new Card("MA"), new Card("ZF"), new Card("PK")
                        )),
                        HandType.NOTHING
                }
        );
    }

    @ParameterizedTest
    @MethodSource("hands")
    void evaluate_shouldReturnCorrectHandType(Hand hand, HandType expected) {
        assertEquals(expected, evaluator.evaluate(hand));
    }
}
