package kw.test.blackkjack.utils;

import com.badlogic.gdx.utils.Array;

import java.util.Random;

import kw.test.blackkjack.card.CardPanel;
import kw.test.blackkjack.data.CardData;

public class CardUtils {
    private Random random = new Random();
    private static CardUtils cardUtils;
    private Array<CardData> cardDatas;
    public static CardUtils getCardUtils() {
        if (cardUtils == null){
            cardUtils = new CardUtils();
        }
        return cardUtils;
    }

    public CardUtils(){
        this.cardDatas = new Array<>();
        initDeskCard();
    }

    public Array<CardData> initDeskCard(){
        /**
         * 0 黑桃
         * 1 红桃
         * 2 梅花
         * 3 方块
         */
        for (int i = 0; i < 4; i++) {
            for (int i1 = 0; i1 < 13; i1++) {
                CardData cardData = new CardData(i1,i);
                cardDatas.add(cardData);
            }
        }
        cardDatas.shuffle(random);
        return cardDatas;
    }

    public CardData getOneCard(){
        return cardDatas.removeIndex(0);
    }
}
