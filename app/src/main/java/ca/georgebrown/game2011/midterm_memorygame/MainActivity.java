//**********************************************************************************
// [[App Name]]
// Me
// Mid-Term Exam: Memory Game App
// [[Authors]]
// Jamie Chingchun Huang – 101088322
// Jose Montenegro Avariano – 101085465
//
// [[Creation Date]] Mar 12, 2018
//
// [[The Source file name]]
// * MainActivity.java
//
//
// [[Description]]
// * Small memory game
// * Random cards work
// * Flip works
//
//***********************************************************************************

package ca.georgebrown.game2011.midterm_memorygame;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class MainActivity extends Activity {
    ArrayList<Card> cards;
    ArrayList<Integer> selectedCards;


    protected void initializeCards(){
        cards = new ArrayList<Card>();
        cards.add(new Card(0,(ImageView) findViewById(R.id.card_1)));
        cards.add(new Card(0,(ImageView) findViewById(R.id.card_2)));
        cards.add(new Card(0,(ImageView) findViewById(R.id.card_3)));
        cards.add(new Card(0,(ImageView) findViewById(R.id.card_4)));
        cards.add(new Card(0,(ImageView) findViewById(R.id.card_5)));
        cards.add(new Card(0,(ImageView) findViewById(R.id.card_6)));
        cards.add(new Card(0,(ImageView) findViewById(R.id.card_7)));
        cards.add(new Card(0,(ImageView) findViewById(R.id.card_8)));
        cards.add(new Card(0,(ImageView) findViewById(R.id.card_9)));
        cards.add(new Card(0,(ImageView) findViewById(R.id.card_10)));
        cards.add(new Card(0,(ImageView) findViewById(R.id.card_11)));
        cards.add(new Card(0,(ImageView) findViewById(R.id.card_12)));
        cards.add(new Card(0,(ImageView) findViewById(R.id.card_13)));
        cards.add(new Card(0,(ImageView) findViewById(R.id.card_14)));
        cards.add(new Card(0,(ImageView) findViewById(R.id.card_15)));
        cards.add(new Card(0,(ImageView) findViewById(R.id.card_16)));
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeCards();

        Random rng = new Random();
        selectedCards = new ArrayList<Integer>();
        for (int i = 0; i < 8; ++i) {
            selectedCards.add(rng.nextInt(52) + 1);
        }

        assignSelectedCards();
    }


}
