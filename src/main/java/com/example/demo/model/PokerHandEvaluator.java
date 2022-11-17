package com.example.demo.model;

import com.example.demo.utils.Rank;
import com.example.demo.utils.Suit;

import java.util.HashMap;
import java.util.ArrayList;

public class PokerHandEvaluator {

    public HashMap<Integer, Integer> setUpRankCounter() {
        HashMap<Integer, Integer> rankCounter = new HashMap<>();
        rankCounter.put(1, 0);
        rankCounter.put(2, 0);
        rankCounter.put(3, 0);
        rankCounter.put(4, 0);
        rankCounter.put(5, 0);
        rankCounter.put(6, 0);
        rankCounter.put(7, 0);
        rankCounter.put(8, 0);
        rankCounter.put(9, 0);
        rankCounter.put(10, 0);
        rankCounter.put(11, 0);
        rankCounter.put(12, 0);
        rankCounter.put(13, 0);
        return rankCounter;
    }

    public HashMap<Rank, Integer> setUpRoyalRankCounter() {
        HashMap<Rank, Integer> royalRankCounter = new HashMap<>();
        royalRankCounter.put(Rank.TEN, 0);
        royalRankCounter.put(Rank.JACK, 0);
        royalRankCounter.put(Rank.QUEEN, 0);
        royalRankCounter.put(Rank.KING, 0);
        royalRankCounter.put(Rank.ACE, 0);
        return royalRankCounter;
    }

    public HashMap<Suit, Integer> setUpSuitCounter() {
        HashMap<Suit, Integer> suitCounter = new HashMap<>();
        suitCounter.put(Suit.DIAMONDS, 0);
        suitCounter.put(Suit.CLUBS, 0);
        suitCounter.put(Suit.HEARTS, 0);
        suitCounter.put(Suit.SPADES, 0);
        return suitCounter;
    }

    public boolean isDuplicateRank(Card card, ArrayList<Card> hand) {
        boolean isDuplicate = false;
        for (Card handCard : hand) {
            if (card.getRank().equals(handCard.getRank())) {
                isDuplicate = true;
            }
        }
        return isDuplicate;
    }

    //hand evaluator methods

    public Card highCard(ArrayList<Card> hand) {
        Integer highestValue = 0;
        Card highCard = null;
        for (Card card : hand) {
            Integer cardValue = card.getRank().getRankValue();
            if (cardValue >= highestValue) {
                highestValue = cardValue;
                highCard = card;
            }
        }
        return highCard;
    }

    public ArrayList< ArrayList<Card> > howManyOfKind(int howMany, ArrayList<Card> hand) {
        ArrayList<ArrayList<Card>> kindCounter = new ArrayList<>();
        HashMap<Integer, Integer> rankCounter = setUpRankCounter();

        //increment rankCounter to determine how many of each kind
        for (Card card : hand) {
            Integer keyOfCard = card.getRank().getRankValue();
            Integer currentValue = rankCounter.get(keyOfCard);
            rankCounter.put(keyOfCard, (currentValue + 1));
        }

        //...check if there is the correct number of a kind
        for (Integer key : rankCounter.keySet()) {
            Integer cardCount = rankCounter.get(key);
            if (cardCount.equals(howMany)) {

                //...and if there is, make an ArrayList of those cards
                ArrayList<Card> kindArray = new ArrayList<>();
                for (Card card : hand) {
                    if ((card.getRank().getRankValue()) == key) {
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
        HashMap<Integer, Integer> rankCounter = setUpRankCounter();

        //increment rankCounter to determine how many of each kind
        for (Card card : hand) {
            Integer keyOfCard = card.getRank().getRankValue();
            Integer currentValue = rankCounter.get(keyOfCard);
            rankCounter.put(keyOfCard, (currentValue + 1));
        }

        //if there are cards of five consecutive ranks
        for (int i=1; i < 10; i++) {
            if ((rankCounter.get(i) > 0) &&
                    (rankCounter.get(i + 1) > 0) &&
                    (rankCounter.get(i + 2) > 0) &&
                    (rankCounter.get(i + 3) > 0) &&
                    (rankCounter.get(i + 4) > 0)) {

                //...and if there are, add each one into straight ArrayList
                for (Card card : hand) {
                    if (((card.getRank().getRankValue() == i) ||
                            (card.getRank().getRankValue() == i + 1) ||
                            (card.getRank().getRankValue() == i + 2) ||
                            (card.getRank().getRankValue() == i + 3) ||
                            (card.getRank().getRankValue() == i + 4)) &&
                            !(isDuplicateRank(card, straight))) {
                        straight.add(card);
                    }
                }
            }
        }

        //separate if for low-ace straight
        if ((rankCounter.get(13) > 0) &&
                (rankCounter.get(1) > 0) &&
                (rankCounter.get(2) > 0) &&
                (rankCounter.get(3) > 0) &&
                (rankCounter.get(4) > 0)) {
            for (Card card : hand) {
                if (((card.getRank().getRankValue() == 13) ||
                        (card.getRank().getRankValue() == 1) ||
                        (card.getRank().getRankValue() == 2) ||
                        (card.getRank().getRankValue() == 3) ||
                        (card.getRank().getRankValue() == 4)) &&
                        !(isDuplicateRank(card, straight))) {
                    straight.add(card);
                }
            }
        }
        return straight;
    }

    public ArrayList<Card> flush(ArrayList<Card> hand) {
        ArrayList<Card> flush = new ArrayList<Card>();
        HashMap<Suit, Integer> suitCounter = setUpSuitCounter();

        //increment suitCounter to determine how many of each suit
        for (Card card : hand) {
            Suit cardSuit = card.getSuit();
            for (Suit suit : suitCounter.keySet()) {
                if (cardSuit.equals(suit)) {
                    Integer currentValue = suitCounter.get(suit);
                    suitCounter.put(suit, (currentValue + 1));
                }
            }
        }

        //...check if there is a flush
        for (Suit suit : suitCounter.keySet()) {
            if (suitCounter.get(suit) == 5) {

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
        for (Card card : hand) {
            workingHand.add(card);
        }

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
        HashMap<Rank, Integer> royalRankCounter = setUpRoyalRankCounter();
        for (Card card : hand) {
            Rank cardRank = card.getRank();
            for (Rank rank : royalRankCounter.keySet()) {
                if (cardRank.equals(rank)) {
                    Integer currentValue = royalRankCounter.get(rank);
                    royalRankCounter.put(rank, (currentValue + 1));
                }
            }
        }

        //...check if there is a royal flush
        if((royalRankCounter.get(Rank.TEN) == 1) &&
                (royalRankCounter.get(Rank.JACK) == 1) &&
                (royalRankCounter.get(Rank.QUEEN) == 1) &&
                (royalRankCounter.get(Rank.KING) == 1) &&
                (royalRankCounter.get(Rank.ACE) == 1)) {

            //and if there is, add the cards into royalFlush
            for (Card card : hand) {
                royalFlush.add(card);
            }
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

    //master method for single hand

    public int evaluateHand(ArrayList<Card> hand) {
        if (isRoyalFlush(hand)) {
            return 9;
        } else if (isStraightFlush(hand)) {
            return 8;
        } else if (isFourOfAKind(hand)) {
            return 7;
        } else if (isFullHouse(hand)) {
            return 6;
        }  else if (isStraight(hand)) {
            return 5;
        } else if (isThreeOfAKind(hand)) {
            return 4;
        } else if (isTwoPair(hand)) {
            return 3;
        } else if (isTwoOfAKind(hand)) {
            return 2;
        } else return 1;
    }

    //methods for comparing hands and determining winner

    public ArrayList<Card> getHandWithHighCard(ArrayList<ArrayList<Card>> hands) {
        int winningScore = 0;
        ArrayList<Card> winningHand = null;
        for (ArrayList<Card> hand : hands) {
            int score = highCard(hand).getRank().getRankValue();
            if (score > winningScore) {
                winningScore = score;
                winningHand = hand;
            }
        }
        return winningHand;
    }

    public ArrayList<Card> getWinningHand(ArrayList<ArrayList<Card>> hands) {
        int winningScore = 0;
        ArrayList<Card> winningHand = null;

        //find the highest score among hands
        for (ArrayList<Card> hand : hands) {
            int score = evaluateHand(hand);
            if (score > winningScore) {
                winningScore = score;
                winningHand = hand;
            }
        }
        //eliminate any hands below winning score
        for (int i=0; i < (hands.size()); i++) {
            int score = evaluateHand(hands.get(i));
            if (score < winningScore) { hands.remove(i); }
        }
        //if there is a draw, compare the highest card
        if (hands.size() > 1) {
            winningScore = 0;
            winningHand = null;
            for (ArrayList<Card> hand : hands) {
                int score = highCard(hand).getRank().getRankValue();
                if (score > winningScore) {
                    winningScore = score;
                    winningHand = hand;
                }
            }
        }
        return winningHand;
    }

}
