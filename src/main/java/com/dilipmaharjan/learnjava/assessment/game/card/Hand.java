package com.dilipmaharjan.learnjava.assessment.game.card;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void clear() {
        cards.clear();
    }

    public void add(Card card) {
        cards.add(card);
    }

    public String show() {
        StringBuilder sb = new StringBuilder();
        boolean allFaceUp = true;
        for (Card card : cards) {
            sb.append(card.toString())
                    .append("\n");
            if (!card.faceup) {
                allFaceUp = false;
            }
            if (allFaceUp) {
                sb.append("Total points : " + getTotalPoints() + " \n");
            }
        }
        return sb.toString();
    }

    public void flipCards() {
        for (Card card : cards) {
            card.flip();
        }
    }

    public boolean give(Card card, Hand otherHand) {
        if (!cards.contains(card)) {
            return false;
        } else {
            cards.remove(card);
            otherHand.add(card);
            return true;
        }
    }

    public int getTotalPoints() {
        int totalPoints = 0;
        boolean hasAce = false;
        for (Card card : cards) {
            totalPoints += card.getRank();
            if (card.getStrRank()
                    .equals("Ace")) {
                hasAce = true;
            }
            //Make ace worth qq if total points <=11
            if (hasAce && totalPoints <= 11) {
                totalPoints += 10;
            }
        }

        return totalPoints;
    }

}
