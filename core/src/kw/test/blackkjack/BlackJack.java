package kw.test.blackkjack;

import com.badlogic.gdx.Game;
import com.kw.gdx.BaseGame;

import kw.test.blackkjack.screen.LoadingScreen;

public class BlackJack extends BaseGame {
    @Override
    protected void loadingView() {
        super.loadingView();
        setScreen(new LoadingScreen(this));
    }
}
