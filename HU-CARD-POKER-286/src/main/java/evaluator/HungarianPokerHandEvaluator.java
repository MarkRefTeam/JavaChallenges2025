package evaluator;

import model.Card;
import model.Colour;
import model.Hand;
import model.Value;

import java.util.Map;
import java.util.stream.Collectors;

public class HungarianPokerHandEvaluator {

    private final HandRuleEvaluator ruleEvaluator = new HandRuleEvaluator();

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

    private HungarianPokerHandEvaluator() {
    }

    public static HungarianPokerHandEvaluator getInstance() {
        return INSTANCE;
    }

    public HandType evaluate(Hand hand) {

        var valueCounts = countValues(hand).values();
        var colourCounts = countColours(hand).values();

        //Map<Value, Long> valueCounts = countValues(hand);
        //Map<Colour, Long> colourCounts = countColours(hand);

        if (ruleEvaluator.isPoker(valueCounts)) {
            return HandType.POKER;
        }

        if (ruleEvaluator.isFlush(colourCounts)) {
            return HandType.FLUSH;
        }

        if (ruleEvaluator.isAlmostFlush(colourCounts)) {
            return HandType.ALMOST_FLUSH;
        }

        return HandType.NOTHING;
    }
}