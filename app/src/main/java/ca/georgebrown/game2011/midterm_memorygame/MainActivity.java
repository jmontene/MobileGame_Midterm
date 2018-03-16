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

    MemoryGame game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game = new MemoryGame(this);
    }


}
