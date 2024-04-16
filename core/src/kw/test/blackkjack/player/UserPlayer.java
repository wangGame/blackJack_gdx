package kw.test.blackkjack.player;

public class UserPlayer extends Iplayer {

    @Override
    public void sendCard() {

    }


    @Override
    public String toString() {
        return "UserPlayer{" +
                "cardPanels=" + cardPanels +
                ",score = "+calScore()+
                '}';
    }
}
