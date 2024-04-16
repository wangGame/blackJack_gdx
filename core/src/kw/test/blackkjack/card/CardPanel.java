package kw.test.blackkjack.card;

import com.badlogic.gdx.scenes.scene2d.Group;

import kw.test.blackkjack.data.CardData;

public class CardPanel extends Group {
    private int cardNum;
    private int suit;

    public CardPanel(CardData cardData) {
        this.cardNum = cardData.getNum()+1;
        this.suit = cardData.getSuit();
    }

    public int getCardNum() {
        return cardNum;
    }

    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "CardPanel{" +
                "cardNum=" + cardNum +
                ", suit=" + suit +
                '}';
    }
}
