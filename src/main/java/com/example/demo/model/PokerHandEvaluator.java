package com.example.demo.model;

import com.example.demo.utils.PokerHandPower;
import com.example.demo.utils.Suit;

import java.util.ArrayList;


public class PokerHandEvaluator {

    public int[] setUpRankCounter() {

        return new int[13];
    }

    public int[] setUpRoyalRankCounter() {
        int[] royalRankCounter = new int[13];
        royalRankCounter[8] = 0;
        royalRankCounter[9] = 0;
        royalRankCounter[10] = 0;
        royalRankCounter[11] = 0;
        royalRankCounter[12] = 0;
        return royalRankCounter;
    }

    public int[] setUpSuitCounter() {
        return new int[4];
    }

    public boolean isDuplicateRank(Card card, ArrayList<Card> hand) {
        boolean isDuplicate = false;
        for (Card handCard : hand) {
            if (card.getRank().ordinal()==handCard.getRank().ordinal()) {
                isDuplicate = true;
            }
            return isDuplicate;
        }
        return false;
    }

    //hand evaluator methods

    public Card highCard(ArrayList<Card> hand) {
        int highestValue = 0;
        Card highCard = null;
        for (Card card : hand) {
            int cardValue = card.getRank().ordinal();
            if (cardValue >= highestValue) {
                highestValue = cardValue;
                highCard = card;
            }
        }
        return highCard;
    }

    public ArrayList<ArrayList<Card>> howManyOfKind(int howMany, ArrayList<Card> hand) {
        ArrayList<ArrayList<Card>> kindCounter = new ArrayList<>();
        int[] rankCounter = setUpRankCounter();

        //increment rankCounter to determine how many of each kind
        for (Card card : hand) {
            int keyOfCard = card.getRank().ordinal();
            int currentValue = rankCounter[keyOfCard];
            rankCounter[keyOfCard] = currentValue + 1;
        }

        //...check if there is the correct number of a kind
        for (int key : rankCounter) {
            int cardCount = rankCounter[key];
            if (cardCount == howMany) {

                //...and if there is, make an ArrayList of those cards
                ArrayList<Card> kindArray = new ArrayList<>();
                for (Card card : hand) {
                    if ((card.getRank().ordinal()) == key) {
                        kindArray.add(card);
                    }
                }
                //...and add it to the kindCounter ArrayList.
                kindCounter.add(kindArray);
            }
        }
        return kindCounter;
    }

    public ArrayList<Card> straight(ArrayList<Card> hand) {
        ArrayList<Card> straight = new ArrayList<>();
        int[] rankCounter = setUpRankCounter();

        //increment rankCounter to determine how many of each kind
        for (Card card : hand) {
            int keyOfCard = card.getRank().ordinal();
            int currentValue = rankCounter[keyOfCard];
            rankCounter[keyOfCard] = (currentValue + 1);
        }

        //if there are cards of five consecutive ranks
        for (int i = 1; i < 10; i++) {
            if ((rankCounter[i] > 0) &&
                    (rankCounter[i + 1] > 0) &&
                    (rankCounter[i + 2] > 0) &&
                    (rankCounter[i + 3] > 0) &&
                    (rankCounter[i + 4] > 0)) {

                //...and if there are, add each one into straight ArrayList
                for (Card card : hand) {
                    if (((card.getRank().ordinal() == i) ||
                            (card.getRank().ordinal() == i + 1) ||
                            (card.getRank().ordinal() == i + 2) ||
                            (card.getRank().ordinal() == i + 3) ||
                            (card.getRank().ordinal() == i + 4)) &&
                            !(isDuplicateRank(card, straight))) {
                        straight.add(card);
                    }
                }
            }
        }

        //separate if for low-ace straight
        if ((rankCounter[12] > 0) &&
                (rankCounter[0] > 0) &&
                (rankCounter[1] > 0) &&
                (rankCounter[2] > 0) &&
                (rankCounter[3] > 0)) {
            for (Card card : hand) {
                if (((card.getRank().ordinal() == 12) ||
                        (card.getRank().ordinal() == 0) ||
                        (card.getRank().ordinal() == 1) ||
                        (card.getRank().ordinal() == 2) ||
                        (card.getRank().ordinal() == 3)) &&
                        !(isDuplicateRank(card, straight))) {
                    straight.add(card);
                }
            }
        }
        return straight;
    }

    public ArrayList<Card> flush(ArrayList<Card> hand) {
        ArrayList<Card> flush = new ArrayList<>();
        int[] suitCounter = setUpSuitCounter();

        //increment suitCounter to determine how many of each suit
        for (Card card : hand) {
            Suit cardSuit = card.getSuit();
            for (Suit suit : Suit.values()) {
                if (cardSuit.equals(suit)) {
                    int currentValue = suitCounter[suit.ordinal()];
                    suitCounter[suit.ordinal()] = currentValue + 1;
                }
            }
        }

        //...check if there is a flush
        for (Suit suit : Suit.values()) {
            if (suitCounter[suit.ordinal()] == 5) {

                //...and if there is, add those cards to the flush ArrayList
                for (Card card : hand) {
                    Suit cardSuit = card.getSuit();
                    if (cardSuit.equals(suit)) {
                        flush.add(card);
                    }
                }
            }
        }
        return flush;
    }

    public ArrayList<Card> fullHouse(ArrayList<Card> hand) {
        ArrayList<Card> fullHouse = new ArrayList<>();

        //set up a copy of hand ArrayList, so that elements can be removed w/o removing from hand
        ArrayList<Card> workingHand = new ArrayList<>();
        workingHand.addAll(hand);

        //gets ArrayList of three-of-a-kind combinations
        ArrayList<ArrayList<Card>> threeOfAKinds = howManyOfKind(3, workingHand);
        for (ArrayList<Card> threeOfAKind : threeOfAKinds) {
            if (!(threeOfAKind.isEmpty())) {
                //if there is a three-of-a-kind, remove it from workingHand
                workingHand.removeAll(threeOfAKind);
                //and check workingHand for two-of-a-kinds
                ArrayList<ArrayList<Card>> twoOfAKinds = howManyOfKind(2, workingHand);
                //if there is a two-of-a-kind
                if (!(twoOfAKinds.isEmpty())) {
                    //add two-of-a-kind to fullHouse, along with three-of-a-kind, making full house
                    fullHouse.addAll(threeOfAKind);
                    fullHouse.addAll(twoOfAKinds.get(0));
                }
            }
        }
        return fullHouse;
    }

    public ArrayList<Card> straightFlush(ArrayList<Card> hand) {
        ArrayList<Card> straightFlush = new ArrayList<>();

        ArrayList<Card> flush = flush(hand);
        //exit early if no flush...
        if (flush.isEmpty()) return straightFlush;
        //else, check if flush is straight
        straightFlush = straight(flush);
        //return straightFlush
        return straightFlush;
    }

    public ArrayList<Card> royalFlush(ArrayList<Card> hand) {
        ArrayList<Card> royalFlush = new ArrayList<>();

        //check if we have a flush
        if (flush(hand).isEmpty()) return royalFlush;

        //...increment royalRankCounter to check how many of each rank
        int[] royalRankCounter = setUpRoyalRankCounter();
        for (Card card : hand) {
            int cardRank = card.getRank().ordinal();
            for (int rank : royalRankCounter) {
                if (cardRank==rank) {
                    int currentValue = royalRankCounter[rank];
                    royalRankCounter[rank]= currentValue + 1;
                }
            }
        }

        //...check if there is a royal flush
        if ((royalRankCounter[8] == 1) &&
                (royalRankCounter[9] == 1) &&
                (royalRankCounter[10] == 1) &&
                (royalRankCounter[11] == 1) &&
                (royalRankCounter[12] == 1)) {

            //and if there is, add the cards into royalFlush
            royalFlush.addAll(hand);
        }
        return royalFlush;
    }

    //boolean methods

    public boolean isTwoOfAKind(ArrayList<Card> hand) {
        ArrayList<ArrayList<Card>> result = howManyOfKind(2, hand);
        return (result.size() == 1);
    }

    public boolean isTwoPair(ArrayList<Card> hand) {
        ArrayList<ArrayList<Card>> result = howManyOfKind(2, hand);
        return (result.size() == 2);
    }

    public boolean isThreeOfAKind(ArrayList<Card> hand) {
        ArrayList<ArrayList<Card>> result = howManyOfKind(3, hand);
        return (result.size() == 1);
    }

    public boolean isStraight(ArrayList<Card> hand) {
        return !(straight(hand).isEmpty());
    }

    public boolean isFlush(ArrayList<Card> hand) {
        return !(flush(hand).isEmpty());
    }

    public boolean isFullHouse(ArrayList<Card> hand) {
        return !(fullHouse(hand).isEmpty());
    }

    public boolean isFourOfAKind(ArrayList<Card> hand) {
        ArrayList<ArrayList<Card>> result = howManyOfKind(4, hand);
        return (result.size() == 1);
    }

    public boolean isStraightFlush(ArrayList<Card> hand) {
        return !(straightFlush(hand).isEmpty());
    }

    public boolean isRoyalFlush(ArrayList<Card> hand) {
        return !(royalFlush(hand).isEmpty());
    }



//    public int evaluateHand(ArrayList<Card> hand) {
//        if (isRoyalFlush(hand)) {
//            return PokerHandPower.ROYALFLUSH.ordinal();
//        } else if (isStraightFlush(hand)) {
//            return PokerHandPower.STRAIGHTFLUSH.ordinal();
//        } else if (isFourOfAKind(hand)) {
//            return PokerHandPower.FOUROFAKIND.ordinal();
//        } else if (isFullHouse(hand)) {
//            return PokerHandPower.FULLHOUSE.ordinal();
//        } else if (isStraight(hand)) {
//            return PokerHandPower.STRAIGHT.ordinal();
//        } else if (isThreeOfAKind(hand)) {
//            return PokerHandPower.THREEOFAKIND.ordinal();
//        } else if (isTwoPair(hand)) {
//            return PokerHandPower.TWOPAIRS.ordinal();
//        } else if (isTwoOfAKind(hand)) {
//            return PokerHandPower.PAIR.ordinal();
//        } else return 0;
//    }





}
