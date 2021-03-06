package com;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;

import com.google.android.glass.touchpad.GestureDetector;
import com.google.android.glass.widget.CardBuilder;
import com.google.android.glass.widget.CardScrollView;

/**
 * Created by eugenio.soberon on 05/04/2017.
 */

public class StepMenuActivity extends Activity{

    private static final String TAG = MachineListActivity.class.getSimpleName();

    private final Handler mHandler = new Handler();
    /** Audio manager used to play system sound effects. */
    private AudioManager mAudioManager;

    /** Gesture detector used to present the options menu. */
    private GestureDetector mGestureDetector;


    private Context context;
    private CardScrollView mCardScroller;
    private CardAdapter mCardAdapter;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        context = this;
        mCardAdapter = new CardAdapter(createCards(this));

        mCardScroller = new CardScrollView(this);
        mCardScroller.setAdapter(mCardAdapter);

        setContentView(mCardScroller);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private List<CardBuilder> createCards(Context context) {

        CardBuilder card1 = new CardBuilder(context, CardBuilder.Layout.TITLE);
        card1.setText("Step 1");


        CardBuilder card2 = new CardBuilder(context, CardBuilder.Layout.TITLE);
        card2.setText("Step 2");

        ArrayList<CardBuilder> cards = new ArrayList<CardBuilder>();
        cards.add(card1);
        cards.add(card2);

        return cards;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCardScroller.activate();
    }

    @Override
    protected void onPause() {
        mCardScroller.deactivate();
        super.onPause();
    }

    private void startAviation() {
        startActivity(new Intent(this, AviationMenuActivity.class));
        finish();
    }

}
