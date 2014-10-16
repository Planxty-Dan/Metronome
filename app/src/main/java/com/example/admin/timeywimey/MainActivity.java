package com.example.admin.timeywimey;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.logging.LogRecord;


public class MainActivity extends Activity {

    private Button mSoundButton;
    private TextView mBeatCount;
    private int mBeatCounter = 0;
    private MediaPlayer mp;
    private CountDownTimer mCountDownTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(getApplicationContext(), R.raw.wood_block);
        mSoundButton = (Button) findViewById(R.id.sound_button);
        mSoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playBeat();
            }
        });
        mBeatCount = (TextView) findViewById(R.id.beat_count);
        mBeatCount.setText(Integer.toString(mBeatCounter));
    }

    public void playBeat() {
       mCountDownTimer = new CountDownTimer(60000, 500) {
           @Override
           public void onTick(long l) {
                mp.start();
           }

           @Override
           public void onFinish() {

           }
       }.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
