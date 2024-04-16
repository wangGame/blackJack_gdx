package kw.test.blackkjack.player;

import com.badlogic.gdx.utils.Array;

import kw.test.blackkjack.card.CardPanel;

public class DealPlayer extends Iplayer{


    @Override
    public void sendCard() {

    }


    @Override
    public String toString() {
        return "DealPlayer{" +
                "cardPanels=" + cardPanels +
                ",score = "+calScore()+
                '}';
    }
}
