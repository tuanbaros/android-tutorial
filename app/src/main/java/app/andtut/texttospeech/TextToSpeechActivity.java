package app.andtut.texttospeech;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

import app.andtut.R;

public class TextToSpeechActivity extends AppCompatActivity {

    TextToSpeech ttobj;
    private EditText write;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_speech);

        write = (EditText)findViewById(R.id.editText1);
        ttobj=new TextToSpeech(getApplicationContext(),
            new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    if(status != TextToSpeech.ERROR){
                        ttobj.setLanguage(Locale.UK);
                    }
                }
            });
    }

    @Override
    public void onPause(){
        if(ttobj !=null){
            ttobj.stop();
            ttobj.shutdown();
        }
        super.onPause();
    }

    public void speakText(View view){
        String toSpeak = write.getText().toString();
        Toast.makeText(getApplicationContext(), toSpeak,
            Toast.LENGTH_SHORT).show();
        ttobj.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }
}
