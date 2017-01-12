package app.andtut.mediaplayer;

import android.databinding.DataBindingUtil;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import app.andtut.R;
import app.andtut.databinding.ActivityMediaPlayerBinding;

public class MediaPlayerActivity extends AppCompatActivity {

    private ActivityMediaPlayerBinding mBinding;

    private MediaPlayer mediaPlayer;
    private double startTime = 0;
    private double finalTime = 0;
    private Handler myHandler = new Handler();;
    private int forwardTime = 5000;
    private int backwardTime = 5000;

    public static int oneTimeOnly = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_media_player);
        mBinding.setActivity(this);

        mBinding.textView4.setText("song.mp3");
        mediaPlayer = MediaPlayer.create(this, R.raw.song);
        mBinding.seekBar1.setClickable(false);
        mBinding.imageButton2.setEnabled(false);
    }

    public void play(){
        Toast.makeText(getApplicationContext(), "Playing sound",
            Toast.LENGTH_SHORT).show();
        mediaPlayer.start();
        finalTime = mediaPlayer.getDuration();
        startTime = mediaPlayer.getCurrentPosition();
        if(oneTimeOnly == 0){
            mBinding.seekBar1.setMax((int) finalTime);
            oneTimeOnly = 1;
        }
        mBinding.textView2.setText(String.format("%d min, %d sec",
            TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
            TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                    toMinutes((long) finalTime)))
        );
        mBinding.textView2.setText(String.format("%d min, %d sec",
            TimeUnit.MILLISECONDS.toMinutes((long) startTime),
            TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                    toMinutes((long) startTime)))
        );
        mBinding.seekBar1.setProgress((int)startTime);
        myHandler.postDelayed(UpdateSongTime, 100);
        mBinding.imageButton2.setEnabled(true);
        mBinding.imageButton1.setEnabled(false);
    }

    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            startTime = mediaPlayer.getCurrentPosition();
            mBinding.textView1.setText(String.format("%d min, %d sec",
                TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                        toMinutes((long) startTime)))
            );
            mBinding.seekBar1.setProgress((int)startTime);
            myHandler.postDelayed(this, 100);
        }
    };
    public void pause() {
        Toast.makeText(getApplicationContext(), "Pausing sound",
            Toast.LENGTH_SHORT).show();
        mediaPlayer.pause();
        mBinding.imageButton2.setEnabled(false);
        mBinding.imageButton1.setEnabled(true);
    }
    public void forward(){
        int temp = (int)startTime;
        if((temp+forwardTime)<=finalTime){
            startTime = startTime + forwardTime;
            mediaPlayer.seekTo((int) startTime);
        }
        else{
            Toast.makeText(getApplicationContext(),
                "Cannot jump forward 5 seconds",
                Toast.LENGTH_SHORT).show();
        }
    }
    public void rewind(){
        int temp = (int)startTime;
        if((temp-backwardTime)>0){
            startTime = startTime - backwardTime;
            mediaPlayer.seekTo((int) startTime);
        }
        else{
            Toast.makeText(getApplicationContext(),
                "Cannot jump backward 5 seconds",
                Toast.LENGTH_SHORT).show();
        }
    }


}
