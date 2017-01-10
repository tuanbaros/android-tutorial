package app.andtut.audiocapture;

import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

import app.andtut.R;
import app.andtut.databinding.ActivityAudioCaptureBinding;

public class AudioCaptureActivity extends AppCompatActivity {

    private ActivityAudioCaptureBinding mBinding;

    private MediaRecorder myAudioRecorder;
    private String outputFile = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_audio_capture);

        mBinding.stopButton.setEnabled(false);
        mBinding.playButton.setEnabled(false);

        outputFile = Environment.getExternalStorageDirectory().
                getAbsolutePath() + "/myrecording.3gp";

        myAudioRecorder = new MediaRecorder();
        myAudioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        myAudioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        myAudioRecorder.setOutputFile(outputFile);

        mBinding.playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    play();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        mBinding.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start();
            }
        });

        mBinding.stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stop();
            }
        });
    }

    public void start() {
        try {
            myAudioRecorder.prepare();
            myAudioRecorder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mBinding.startButton.setEnabled(false);
        mBinding.stopButton.setEnabled(true);

        Toast.makeText(getApplicationContext(), "Recording started",
                Toast.LENGTH_LONG).show();
    }

    public void stop() {
        myAudioRecorder.stop();
        myAudioRecorder.release();
        myAudioRecorder = null;
        mBinding.stopButton.setEnabled(false);
        mBinding.playButton.setEnabled(true);

        Toast.makeText(getApplicationContext(), "Audio is recorded successfully",
                Toast.LENGTH_LONG).show();
    }

    public void play() throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        MediaPlayer m = new MediaPlayer();
        m.setDataSource(outputFile);
        m.prepare();
        m.start();

        Toast.makeText(getApplicationContext(), "Playing audio",
                Toast.LENGTH_LONG).show();
    }
}
