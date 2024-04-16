package kw.test.blackkjack.screen;

import com.badlogic.gdx.utils.Array;
import com.kw.gdx.BaseGame;
import com.kw.gdx.screen.BaseScreen;

import kw.test.blackkjack.card.CardPanel;
import kw.test.blackkjack.data.CardData;
import kw.test.blackkjack.player.DealPlayer;
import kw.test.blackkjack.player.Iplayer;
import kw.test.blackkjack.player.UserPlayer;
import kw.test.blackkjack.utils.CardUtils;

public class GameScreen extends BaseScreen {
    private Iplayer dealPlayer;
    private Iplayer userPlayer;
    public GameScreen(BaseGame game) {
        super(game);
        this.dealPlayer = new DealPlayer();
        this.userPlayer = new UserPlayer();
    }

    @Override
    public void initView() {
        super.initView();
        sendcard();
        showHandInfo();
        hit();
        stand();
    }

    private void stand() {
        if (userPlayer.calScore()>21){
            System.out.println("dealplayer success");
            return;
        }
        while (dealPlayer.calScore()<18){
            dealPlayer.addCard(new CardPanel(CardUtils.getCardUtils().getOneCard()));
            System.out.println(dealPlayer);
        }
        System.out.println("end");
        if (userPlayer.calScore()>=dealPlayer.calScore()){
            System.out.println("userplayer success");
        }else {
            if (dealPlayer.calScore()>21){
                System.out.println("userplayer success");
            }else {
                System.out.println("dealplayer success");
            }
        }
    }

    public void sendcard(){
        for (int i = 0; i < 2; i++) {
            dealPlayer.addCard(new CardPanel(CardUtils.getCardUtils().getOneCard()));
            userPlayer.addCard(new CardPanel(CardUtils.getCardUtils().getOneCard()));
        }
    }

    public void hit(){
        userPlayer.addCard(new CardPanel(CardUtils.getCardUtils().getOneCard()));
        System.out.println(userPlayer);
    }

    public void showHandInfo(){
        dealPlayer.showInfo();
        userPlayer.showInfo();
    }

    @Override
    public void render(float delta) {
        super.render(delta);

    }
}
