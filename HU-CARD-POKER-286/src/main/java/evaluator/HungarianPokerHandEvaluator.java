package evaluator;

import model.Card;
import model.Colour;
import model.Hand;
import model.Value;

import java.util.Map;
import java.util.stream.Collectors;

public class HungarianPokerHandEvaluator {

    private static final HungarianPokerHandEvaluator INSTANCE =
            new HungarianPokerHandEvaluator();

    private Map<Colour, Long> countColours(Hand hand) {
        return hand.getCards().stream()
                .collect(Collectors.groupingBy(
                        Card::getColour,
                        Collectors.counting()
                ));
    }

    private Map<Value, Long> countValues(Hand hand) {
        return hand.getCards().stream()
                .collect(Collectors.groupingBy(
                        Card::getValue,
                        Collectors.counting()
                ));
    }

    private HungarianPokerHandEvaluator() {}

    public static HungarianPokerHandEvaluator getInstance() {
        return INSTANCE;
    }

    public HandType evaluate(Hand hand) {

        var valueCounts = countValues(hand).values();
        var colourCounts = countColours(hand).values();

        //Map<Value, Long> valueCounts = countValues(hand);
        //Map<Colour, Long> colourCounts = countColours(hand);


        //1.) Poker!
        boolean isPoker = valueCounts.stream()
                .anyMatch(count -> count == 4L);

        if(isPoker) {
            return HandType.POKER;
        }

        //2.) Flush!
        boolean isFlush = colourCounts.stream()
                .anyMatch(count -> count == 7L);

        if(isFlush) {
            return HandType.FLUSH;
        }

        //3.) Almost Flush!
        boolean isAlmostFlush = colourCounts.stream()
                .anyMatch(count -> count >= 4L && count <= 7L);

        if(isAlmostFlush) {
            return HandType.ALMOST_FLUSH;
        }

        //4.) Nothing
        return HandType.NOTHING;
    }
}
