package ca.georgebrown.game2011.midterm_memorygame;

import android.view.View;

/**
 * Created by mjose on 2018-03-12.
 */

public class CardClickListener implements View.OnClickListener{
    MemoryGame game;
    Card card;

    public CardClickListener(Card c, MemoryGame g){
        card = c;
        game = g;
    }

    public void onClick(View view){
        game.pickCard(card);
    }
}
