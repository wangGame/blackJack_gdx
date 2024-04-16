package kw.test.blackkjack.player;

import com.badlogic.gdx.utils.Array;

import kw.test.blackkjack.card.CardPanel;

public abstract class Iplayer {
    protected Array<CardPanel> cardPanels;
    public Iplayer(){
        this.cardPanels = new Array<>();
    }

    public float calScore(){
        int isA = 0;
        int score = 0;
        for (CardPanel cardPanel : cardPanels) {
            int cardNum = cardPanel.getCardNum();
            score += cardNum;
            if (cardNum == 1){
                isA ++;
            }
        }
        for (int i = 0; i < isA; i++) {
            if (score > 12) {
                break;
            }
            score += 9;
        }
        return score;
    }

    public abstract void sendCard();

    public void addCard(CardPanel cardPanel){
        cardPanels.add(cardPanel);
    }

    public void showInfo() {
        System.out.println(toString());
    }

}
