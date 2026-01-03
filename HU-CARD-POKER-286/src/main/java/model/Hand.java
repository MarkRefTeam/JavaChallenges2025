package model;

import exception.InvalidHandException;

import java.util.List;

public class Hand {

    private final List<Card> cards;

    public Hand(List<Card> cards) {
        if(cards.size() != 7) {
            throw new InvalidHandException(
                    "A hand must contain exactly 7 cards, got: "
                    + cards.size()
            );
        }
        this.cards = List.copyOf(cards);
    }

    public List<Card> getCards() {
        return cards;
    }
}
