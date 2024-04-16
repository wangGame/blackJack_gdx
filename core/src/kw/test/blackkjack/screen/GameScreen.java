package kw.test.blackkjack.screen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.kw.gdx.BaseGame;
import com.kw.gdx.asset.Asset;
import com.kw.gdx.constant.Constant;
import com.kw.gdx.listener.OrdinaryButtonListener;
import com.kw.gdx.screen.BaseScreen;

import kw.test.blackkjack.card.CardPanel;
import kw.test.blackkjack.data.CardData;
import kw.test.blackkjack.group.BtnGroup;
import kw.test.blackkjack.player.DealPlayer;
import kw.test.blackkjack.player.Iplayer;
import kw.test.blackkjack.player.UserPlayer;
import kw.test.blackkjack.utils.CardUtils;

public class GameScreen extends BaseScreen {
    private Iplayer dealPlayer;
    private Iplayer userPlayer;
    private Label userScore;
    private Label dealScore;
    private Label endLabel;
    private final float labelOffsetY = 400;
    private BtnGroup resetBtn;
    private BtnGroup hitGroup;
    private BtnGroup standGroup;
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
        dealScore = new Label("ABCD",new Label.LabelStyle(){{
            font = Asset.getAsset().loadBitFont("Pt-36.fnt");
        }});
        addActor(dealScore);
        dealScore.setAlignment(Align.center);
        dealScore.setPosition(Constant.GAMEWIDTH/2.0f,Constant.GAMEHIGHT-labelOffsetY, Align.center);
        dealScore.setColor(Color.BLUE);

        endLabel = new Label("end",new Label.LabelStyle(){
            {
                font = Asset.getAsset().loadBitFont("Pt-36.fnt");
            }
        });
        addActor(endLabel);
        endLabel.setAlignment(Align.center);
        endLabel.setPosition(Constant.GAMEWIDTH/2.0f,Constant.GAMEHIGHT/2.0f,Align.center);
        endLabel.setColor(Color.BLACK);
        userScore = new Label("ABCD",new Label.LabelStyle(){{
            font = Asset.getAsset().loadBitFont("Pt-36.fnt");
        }});
        addActor(userScore);
        userScore.setAlignment(Align.center);
        userScore.setPosition(Constant.GAMEWIDTH/2.0f,labelOffsetY, Align.center);
        userScore.setColor(Color.BLUE);
        setLabelScore();
        hitGroup = new BtnGroup("hit");
        addActor(hitGroup);
        hitGroup.setPosition(Constant.GAMEWIDTH/2.0f-200,labelOffsetY/2.0f,Align.center);
        hitGroup.addListener(new OrdinaryButtonListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                hit();
            }
        });
        standGroup = new BtnGroup("stand");
        addActor(standGroup);
        standGroup.setPosition(Constant.GAMEWIDTH/2.0f+200,labelOffsetY/2.0f,Align.center);
        standGroup.addListener(new OrdinaryButtonListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                stand();
                hitGroup.setVisible(false);
                standGroup.setVisible(false);
            }
        });

        resetBtn = new BtnGroup("Rest");
        resetBtn.setVisible(false);
        addActor(resetBtn);
        resetBtn.setPosition(Constant.GAMEWIDTH/2.0f,600,Align.center);
        resetBtn.addListener(new OrdinaryButtonListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                userPlayer.clear();
                dealPlayer.clear();
                setLabelScore();
                hitGroup.setVisible(true);
                standGroup.setVisible(true);
                resetBtn.setVisible(false);
            }
        });
//        hit();
//        stand();
    }

    public void setLabelScore(){
        dealScore.setText(dealPlayer.calScore()+"");
        userScore.setText(userPlayer.calScore()+"");
    }

    private void stand() {
        if (userPlayer.calScore()>21){
            System.out.println("dealplayer success");
            endLabel.setText("dealplayer success");
            return;
        }

        if (dealPlayer.calScore()<18){
            dealPlayer.addCard(new CardPanel(CardUtils.getCardUtils().getOneCard()));
            System.out.println(dealPlayer);
            setLabelScore();
            stage.addAction(Actions.delay(0.5f,Actions.run(()->{
                stand();
            })));
        }else {
            resetBtn.setVisible(true);
            System.out.println("end");
            if (userPlayer.calScore()>=dealPlayer.calScore()){
                System.out.println("userplayer success");
                endLabel.setText("userplayer success");
            }else {
                if (dealPlayer.calScore()>21){
                    System.out.println("userplayer success");
                    endLabel.setText("userplayer success");
                }else {
                    System.out.println("dealplayer success");
                    endLabel.setText("dealplayer success");
                }
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
        setLabelScore();

        if (userPlayer.calScore()>21){
            System.out.println("dealplayer success");
            endLabel.setText("dealplayer success");
            hitGroup.setVisible(false);
            standGroup.setVisible(false);
            resetBtn.setVisible(true);
            return;
        }
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
