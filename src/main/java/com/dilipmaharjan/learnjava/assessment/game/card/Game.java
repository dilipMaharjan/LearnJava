package com.dilipmaharjan.learnjava.assessment.game.card;

public class Game {
    public static void main(String[] args) {

        //create a Deck
        Deck deck = new Deck();
        deck.create();

        //shuffle cards
        deck.shuffle();

        //create playing hands

        Hand hand = new Hand();
        Hand hand1 = new Hand();
        Hand hand2 = new Hand();
        Hand dealer = new Hand();
        Hand[] hands = {hand, hand1, hand2,dealer};

        //deal cards

        deck.deal(hands, 2);

        // Show players hands

        for (Hand hand3 : hands) {
            hand3.flipCards();
            System.out.println(hand3.show());
        }
        //flip dealers first card
        dealer.cards.get(0)
                .flip();

        System.out.println("Dealers cards : \n " + dealer.show());
    }
}
