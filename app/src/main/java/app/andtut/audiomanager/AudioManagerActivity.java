package app.andtut.audiomanager;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import app.andtut.R;
import app.andtut.databinding.ActivityAudioManagerBinding;

public class AudioManagerActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityAudioManagerBinding mBinding;

    private AudioManager myAudioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_audio_manager);
        myAudioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        mBinding.modeButton.setOnClickListener(this);
        mBinding.vibrateButton.setOnClickListener(this);
        mBinding.silentButton.setOnClickListener(this);
        mBinding.ringButton.setOnClickListener(this);
    }

    public void vibrate() {
        myAudioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
    }

    public void mode() {
        int mod = myAudioManager.getRingerMode();
        if(mod == AudioManager.RINGER_MODE_NORMAL){
            mBinding.statusTextView.setText("Current Status: Ring");
        }
        else if(mod == AudioManager.RINGER_MODE_SILENT){
            mBinding.statusTextView.setText("Current Status: Silent");
        }
        else if(mod == AudioManager.RINGER_MODE_VIBRATE){
            mBinding.statusTextView.setText("Current Status: Vibrate");
        } else {

        }
    }

    public void ring() {
        myAudioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
    }

    public void silent() {
        myAudioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mode_button:
                mode();
                break;
            case R.id.vibrate_button:
                vibrate();
                break;
            case R.id.silent_button:
                silent();
                break;
            case R.id.ring_button:
                ring();
                break;
            default: break;
        }
    }
}
