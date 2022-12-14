package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.GameRepository;
import com.example.demo.utils.PokerHandPower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {


    @Autowired
    private GameRepository gameRepository;

    public static PokerHandPower getPokerHandPowerByOrdinal(int id) {
        for (PokerHandPower pokerHandPower : PokerHandPower.values()) {
            if (pokerHandPower.getOrdinal() == id) return pokerHandPower;
        }
        return null;
    }

    //todo pe front generez dropdown cu alegerile posibile
    public void setMove(int gameId, Information newInformation) {
        GameModel gameModel = gameRepository.getGame(gameId);
        if (gameModel != null) {
            InformationModel actualInformation = gameModel.getLastInformation();
            Integer index = getIndexById(gameModel, gameModel.getCurrentPlayerId());
            InformationModel newInfo = createGameInformation(newInformation);
            if (newInfo != null && index != null && ((newInfo.greaterThan(actualInformation)))) {
                gameRepository.getGame(gameId).setLastInformation(newInfo);
                gameModel.setCurrentPlayerId(gameModel.getPlayers().get((index + 1) % gameModel.getMaxPlayer()).getId());
            }
        }
        // set current player id with next userid + set type of decision to be made
    }

    private InformationModel createGameInformation(Information newInformation) {
        if (getPokerHandPowerByOrdinal(newInformation.getPokerHandPower()) != null && newInformation.getValue() > -1 && newInformation.getValue() < 13) {
            PokerHandPower pokerHandPower = PokerHandPower.values()[newInformation.getPokerHandPower()];
            if (pokerHandPower == PokerHandPower.TWOPAIRS || pokerHandPower == PokerHandPower.FULLHOUSE) {
                if (newInformation.getSecondValue() > -1 && newInformation.getSecondValue() < 13) {
                    return new InformationModel(getPokerHandPowerByOrdinal(newInformation.getPokerHandPower()), newInformation.getValue(), newInformation.getSecondValue());
                }
            } else if (pokerHandPower == PokerHandPower.STRAIGHTFLUSH || pokerHandPower == PokerHandPower.ROYALFLUSH) {
                if (newInformation.getSecondValue() > -1 && newInformation.getSecondValue() < 4) {
                    return new InformationModel(getPokerHandPowerByOrdinal(newInformation.getPokerHandPower()), newInformation.getValue(), newInformation.getSecondValue());
                }
            } else if (newInformation.getSecondValue() == null) {
                return new InformationModel(getPokerHandPowerByOrdinal(newInformation.getPokerHandPower()), newInformation.getValue(), newInformation.getSecondValue());
            }
        }
        return null;
    }

    private Integer getIndexById(GameModel gameModel, int playerId) {
        for (int i = 0; i < gameModel.getMaxPlayer(); i++) {
            if (gameModel.getPlayers().get(i).getId() == playerId) {
                return i;
            }
        }
        return null;
    }

    public boolean isLying(int gameId) {
        GameModel gameModel = gameRepository.getGame(gameId);
        List<PlayerModel> playerModels = gameModel.getPlayers();
        InformationModel lastGameInfo = gameModel.getLastInformation();
        boolean isLie = false;
        int[] allCards = new int[13];
        playerModels.forEach(player ->
                player.getHand().forEach(card -> allCards[card.getRank().ordinal()]++));
        gameModel.getTableCards().forEach(card -> allCards[card.getRank().ordinal()]++);

        PokerHandPower pokerHandPower = lastGameInfo.getPokerHandPower();
        if (pokerHandPower.name().equals(PokerHandPower.HIGHCARD.name()) && allCards[lastGameInfo.getValue()] != 1) {
            isLie = true;
        } else if (pokerHandPower.name().equals(PokerHandPower.PAIR.name()) && allCards[lastGameInfo.getValue()] != 2) {
            isLie = true;
        } else if (pokerHandPower.name().equals(PokerHandPower.TWOPAIRS.name()) && allCards[lastGameInfo.getValue()] != 2 || allCards[lastGameInfo.getSecondValue()] != 2) {
            isLie = true;
        } else if (pokerHandPower.name().equals(PokerHandPower.THREEOFAKIND.name()) && allCards[lastGameInfo.getValue()] != 3) {
            isLie = true;
        } else if (pokerHandPower.name().equals(PokerHandPower.STRAIGHT.name())) {
            if (lastGameInfo.getValue() <= 10)
                for (int i = 0; i < 5; i++) {
                    if (allCards[lastGameInfo.getValue() + i] == 0)
                        return true;
                    else {
                        if (allCards[12] == 0 ||
                                (allCards[0] == 0) ||
                                (allCards[1] == 0) ||
                                (allCards[2] == 0) ||
                                (allCards[3] == 0))
                            return true;

                    }
                }
        } else if (pokerHandPower.name().equals(PokerHandPower.FULLHOUSE.name()) && allCards[lastGameInfo.getValue()] != 3 || allCards[lastGameInfo.getSecondValue()] != 2) {
            isLie = true;
        } else if (pokerHandPower.name().equals(PokerHandPower.FOUROFAKIND.name()) && allCards[lastGameInfo.getValue()] != 4) {
            isLie = true;
        } else {
            int[] cardColor = new int[52];
            if (pokerHandPower.name().equals(PokerHandPower.STRAIGHTFLUSH.name())) {

                //ma duc prin player:players si iau culoarea si valoarea din players hand, si dupa din tablecards
                //pot sa incerc la culoare cu vector[rank] care are 52 carti si aleg culoarea dupa rank=pozitie in vector - culoare x 13
                playerModels.forEach(player ->
                        player.getHand().forEach(card -> cardColor[card.getRank().ordinal() + 13 * card.getSuit().ordinal()] = card.getSuit().ordinal()));

                gameModel.getTableCards().forEach(card -> cardColor[card.getRank().ordinal() + 13 * card.getSuit().ordinal()] = card.getSuit().ordinal());

                if (lastGameInfo.getValue() <= 10)
                    for (int i = 0; i < 5; i++) {
                        if (allCards[lastGameInfo.getValue() + i] == 0 || cardColor[lastGameInfo.getSecondValue() * 13 + lastGameInfo.getValue()] != lastGameInfo.getSecondValue())
                            return true;
                    }
                else if (allCards[12] == 0 || cardColor[lastGameInfo.getSecondValue() * 13 + 12] != lastGameInfo.getSecondValue() ||
                        (allCards[0] == 0 || cardColor[lastGameInfo.getSecondValue() * 13] != lastGameInfo.getSecondValue()) ||
                        (allCards[1] == 0 || cardColor[lastGameInfo.getSecondValue() * 13 + 1] != lastGameInfo.getSecondValue()) ||
                        (allCards[2] == 0 || cardColor[lastGameInfo.getSecondValue() * 13 + 2] != lastGameInfo.getSecondValue()) ||
                        (allCards[3] == 0 || cardColor[lastGameInfo.getSecondValue() * 13 + 3] != lastGameInfo.getSecondValue()))
                    return true;

            } else if (pokerHandPower.name().equals(PokerHandPower.ROYALFLUSH.name())) {
                playerModels.forEach(player ->
                        player.getHand().forEach(card -> cardColor[card.getRank().ordinal() + 13 * card.getSuit().ordinal()] = card.getSuit().ordinal()));

                gameModel.getTableCards().forEach(card -> cardColor[card.getRank().ordinal() + 13 * card.getSuit().ordinal()] = card.getSuit().ordinal());
                for (int i = 0; i < 5; i++) {
                    if (allCards[lastGameInfo.getValue() + i] == 0 || cardColor[lastGameInfo.getSecondValue() * 13 + lastGameInfo.getValue()] != lastGameInfo.getSecondValue())
                        return true;
                }
            }
        }

        return isLie;
    }

    public GameModel getGame(int id) {
        return gameRepository.getGame(id)
                ;
    }

    public PlayerSession joinGame(String name) {
        return gameRepository.joinGame(name);
    }

    public GameStateModel getGameSession(PlayerSession playerSession) {
        return gameRepository.getGameSession(playerSession);
    }


}
//{
//HandPower : 2
//value:3
//secondValue:2