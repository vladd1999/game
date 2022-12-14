package com.example.demo.model;
import com.example.demo.utils.Dealing;

import java.util.List;

public class DealerCardModel implements Dealing {

    DeckModel deckModel;

    public DealerCardModel() {
        this.deckModel = new DeckModel();
    }

    public DeckModel getDeck() {
        return deckModel;
    }

    public void setDeck(DeckModel deckModel) {
        this.deckModel = deckModel;
    }

    public CardModel getCard(int index) {
        return deckModel.get(index);
    }

    public CardModel drawCard(int index) {

        CardModel cardModel = getCard(index);
        deckModel.remove(index);
        return cardModel;
    }

    public void dealCard(PlayerModel playerModel, CardModel cardModel) {
        playerModel.getHand().add(cardModel);
    }

    public void deal(List<PlayerModel> playerModels) {
        playerModels.forEach(player->{
            for (int i = 0; i < player.getHand().size(); i++) {
                CardModel cardModel = drawCard(0);
                dealCard(player, cardModel);
            }});
    }

    public void dealTable(List<CardModel> table) {
        for (int i = 0; i < 5; i++) {
            CardModel cardModel = drawCard(0);
            table.add(cardModel);
        }
    }

}