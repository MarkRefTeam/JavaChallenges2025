import evaluator.HandType;
import evaluator.HungarianPokerHandEvaluator;
import model.Card;
import model.Hand;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Hand hand = new Hand(List.of(
                new Card("M7"), new Card("M8"), new Card("M9"),
                new Card("MT"), new Card("MA"), new Card("MF"), new Card("MK")
        ));

        HandType type = HungarianPokerHandEvaluator.getInstance().evaluate(hand);
        System.out.println("Hand type: " + type);
    }
}
