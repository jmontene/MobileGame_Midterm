package ca.georgebrown.game2011.midterm_memorygame;

import android.os.Handler;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import android.app.Activity;
import android.widget.TextView;

/**
 * Created by mjose on 2018-03-12.
 */

public class MemoryGame {
    ArrayList<Card> cards;
    ArrayList<Integer> selectedCards;

    Activity parent;
    boolean firstPick;

    Card first;
    Card second;
    Runnable flipRunnable;
    Runnable invisibleRunnable;
    Runnable timerRunnable;
    Handler operationsHandler;

    TextView pickLabel;
    TextView scoreLabel;
    TextView timerLabel;

    int score = 0;
    int time = 30;
    int tappedCards = 0;

    public MemoryGame(Activity activity){
        parent = activity;
        firstPick = true;

        initializeCards();

        Random rng = new Random();
        selectedCards = new ArrayList<Integer>();
        for (int i = 0; i < 8; ++i) {
            selectedCards.add(rng.nextInt(52) + 1);
        }

        assignSelectedCards();

        flipRunnable = new Runnable(){
            @Override
            public void run(){
                first.flip();
                second.flip();
                tappedCards = 0;
            }
        };
        invisibleRunnable = new Runnable(){
            @Override
            public void run(){
                first.setInvisible();
                second.setInvisible();
                tappedCards = 0;
            }
        };
        timerRunnable = new Runnable(){
            @Override
            public void run(){
                time -= 1;
                timerLabel.setText(String.valueOf(time));

                if(time > 0){
                    operationsHandler.postDelayed(timerRunnable, 1000);
                }else{
                    gameEnd();
                }
            }
        };

        operationsHandler = new Handler();
        operationsHandler.postDelayed(timerRunnable, 1000);

        pickLabel = (TextView) parent.findViewById(R.id.pickLabel);
        scoreLabel = (TextView) parent.findViewById(R.id.scoreLabel);
        timerLabel = (TextView) parent.findViewById(R.id.timer);
    }

    public void pickCard(Card c){
        if(tappedCards == 2){
            return;
        }else{
            tappedCards += 1;
        }
        if(firstPick){
            first = c;
            c.flip();
            firstPick = false;
            pickLabel.setText("Pick another card");
        }else{
            second = c;
            c.flip();
            if(second != first && second.getValue() == first.getValue()){
                operationsHandler.postDelayed(invisibleRunnable, 500);
                score += 1;
                scoreLabel.setText(String.valueOf(score));
            }else{
                operationsHandler.postDelayed(flipRunnable, 500);
            }
            firstPick = true;
            pickLabel.setText("Pick a card, any card");
        }
    }


    protected void initializeCards(){
        cards = new ArrayList<Card>();
        cards.add(new Card(0,(ImageView) parent.findViewById(R.id.card_1), this));
        cards.add(new Card(0,(ImageView) parent.findViewById(R.id.card_2), this));
        cards.add(new Card(0,(ImageView) parent.findViewById(R.id.card_3), this));
        cards.add(new Card(0,(ImageView) parent.findViewById(R.id.card_4), this));
        cards.add(new Card(0,(ImageView) parent.findViewById(R.id.card_5), this));
        cards.add(new Card(0,(ImageView) parent.findViewById(R.id.card_6), this));
        cards.add(new Card(0,(ImageView) parent.findViewById(R.id.card_7), this));
        cards.add(new Card(0,(ImageView) parent.findViewById(R.id.card_8), this));
        cards.add(new Card(0,(ImageView) parent.findViewById(R.id.card_9), this));
        cards.add(new Card(0,(ImageView) parent.findViewById(R.id.card_10), this));
        cards.add(new Card(0,(ImageView) parent.findViewById(R.id.card_11), this));
        cards.add(new Card(0,(ImageView) parent.findViewById(R.id.card_12), this));
        cards.add(new Card(0,(ImageView) parent.findViewById(R.id.card_13), this));
        cards.add(new Card(0,(ImageView) parent.findViewById(R.id.card_14), this));
        cards.add(new Card(0,(ImageView) parent.findViewById(R.id.card_15), this));
        cards.add(new Card(0,(ImageView) parent.findViewById(R.id.card_16), this));
    }

    protected void assignSelectedCards(){
        Random rng = new Random();
        int selectedIndex = 0;
        HashSet<Integer> chosenIndices = new HashSet<Integer>();
        while(chosenIndices.size() < 16){
            int idx1 = rng.nextInt(16);
            while(chosenIndices.contains(idx1)){
                idx1 = rng.nextInt(16);
            }
            cards.get(idx1).setValue(selectedCards.get(selectedIndex));
            chosenIndices.add(idx1);

            int idx2 = rng.nextInt(16);
            while(chosenIndices.contains(idx2)){
                idx2 = rng.nextInt(16);
            }
            cards.get(idx2).setValue(selectedCards.get(selectedIndex++));
            chosenIndices.add(idx2);
        }

        drawCards();
    }

    protected void drawCards() {
        for (Card c : cards) {
            c.draw();
        }
    }

    public void gameEnd(){
        for(int i=0;i<cards.size();++i){
            cards.get(i).setInvisible();
        }
    }
}
