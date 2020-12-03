package com.dilipmaharjan.learnjava.assessment.game.card;

public class Card {
    private Suit suit;
    private Rank rank;
    boolean faceup;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit.getSuit();
    }

    public int getRank() {
        return rank.getRankValue();
    }

    public String getStrRank() {
        return rank.getStrRankValue();
    }

    public String toString() {
        return this.faceup ? new StringBuilder().append(rank.getStrRankValue())
                .append(" of ")
                .append(getSuit())
                .toString() : " Card is face down, it cannot be viewed. ";
    }

    public void flip() {
        this.faceup = true;
    }
}
