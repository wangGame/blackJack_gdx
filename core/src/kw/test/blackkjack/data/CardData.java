package kw.test.blackkjack.data;

public class CardData {
    private int num;
    private int suit;

    public CardData(int num, int suit) {
        this.num = num;
        this.suit = suit;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }
}
