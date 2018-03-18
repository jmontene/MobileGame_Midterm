//**********************************************************************************
// [[App Name]]
// Midterm_MemoryGame
//
// [[Authors]]
// Jamie Chingchun Huang – 101088322
// Jose Montenegro Avariano – 101085465
//
// [[Creation Date]] Mar 12, 2018
//
// [[The Source file name]]
// * MainActivity.java, MemoryGame.java, CardClickListener.java, Card.java
//
//
// [[Description]]
// * Memory game working well
//
//***********************************************************************************

package ca.georgebrown.game2011.midterm_memorygame;

import android.view.View;
import android.widget.ImageView;

/**
 * Created by mjose on 2018-03-12.
 */

public class Card{
    public static int[] cardIDs = {
            R.drawable.card_1c,
            R.drawable.card_1d,
            R.drawable.card_1h,
            R.drawable.card_1s,
            R.drawable.card_2c,
            R.drawable.card_2d,
            R.drawable.card_2h,
            R.drawable.card_2s,
            R.drawable.card_3c,
            R.drawable.card_3d,
            R.drawable.card_3h,
            R.drawable.card_3s,
            R.drawable.card_4c,
            R.drawable.card_4d,
            R.drawable.card_4h,
            R.drawable.card_4s,
            R.drawable.card_5c,
            R.drawable.card_5d,
            R.drawable.card_5h,
            R.drawable.card_5s,
            R.drawable.card_6c,
            R.drawable.card_6d,
            R.drawable.card_6h,
            R.drawable.card_6s,
            R.drawable.card_7c,
            R.drawable.card_7d,
            R.drawable.card_7h,
            R.drawable.card_7s,
            R.drawable.card_8c,
            R.drawable.card_8d,
            R.drawable.card_8h,
            R.drawable.card_8s,
            R.drawable.card_9c,
            R.drawable.card_9d,
            R.drawable.card_9h,
            R.drawable.card_9s,
            R.drawable.card_10c,
            R.drawable.card_10d,
            R.drawable.card_10h,
            R.drawable.card_10s,
            R.drawable.card_11c,
            R.drawable.card_11d,
            R.drawable.card_11h,
            R.drawable.card_11s,
            R.drawable.card_12c,
            R.drawable.card_12d,
            R.drawable.card_12h,
            R.drawable.card_12s,
            R.drawable.card_13c,
            R.drawable.card_13d,
            R.drawable.card_13h,
            R.drawable.card_13s
    };

    public static Card cardClicked;
    public static int numCards = 0;

    int value;
    ImageView view;
    boolean flipped;
    MemoryGame game;
    String name;

    public Card(int val, ImageView v, MemoryGame g){
        value = val;
        flipped = false;
        view = v;
        name = "card_" + (++numCards);

        view.setClickable(true);
        setGame(g);
        view.setOnClickListener(new CardClickListener(this, game));
    }

    public int getValue(){
        return value;
    }

    public void setValue(int v){
        value = v;
    }

    public void flip(){
        flipped = !flipped;
        draw();
    }

    public void draw(){
        if(flipped){
            view.setImageResource(cardIDs[value]);
        }else{
            view.setImageResource(R.drawable.cardback);
        }
    }

    public void setGame(MemoryGame g){
        game = g;
    }

    public void setInvisible() {
        view.setVisibility(View.INVISIBLE);
    }

    public void setVisible() {
        view.setVisibility(View.VISIBLE);
    }
}
