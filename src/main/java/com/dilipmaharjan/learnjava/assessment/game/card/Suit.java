package com.dilipmaharjan.learnjava.assessment.game.card;

public enum Suit {
    HEART("Heart"),
    SPADE("Spade"),
    CLUB("Club"),
    DIAMOND("Diamond");

    private final String suitValue;

    private Suit(String suitValue) {
        this.suitValue = suitValue;
    }

    public String getSuit() {
        return suitValue;
    }
}
