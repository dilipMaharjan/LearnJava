package com.dilipmaharjan.learnjava.assessment.game.card;

import java.util.Collections;

public class Deck extends Hand {
    public void create() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new Card(suit, rank);
                card.flip();
                cards.add(card);
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void deal(Hand[] hands, int perHand) {
        for (int i = 0; i < perHand; i++) {
            for (Hand hand : hands) {
                this.give(cards.get(0), hand);
            }
        }
    }

    public void deal(Hand hand, int perHand) {
        for (int i = 0; i < perHand; i++) {
            this.give(cards.get(0), hand);
        }
    }

    /**
     * TODO : split card
     */
}
