package app.andtut.spellchecker;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.service.textservice.SpellCheckerService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.textservice.SentenceSuggestionsInfo;
import android.view.textservice.SpellCheckerSession;
import android.view.textservice.SuggestionsInfo;
import android.view.textservice.TextInfo;
import android.view.textservice.TextServicesManager;
import android.widget.Toast;

import app.andtut.R;
import app.andtut.databinding.ActivitySpellCheckerBinding;

public class SpellCheckerActivity extends AppCompatActivity implements
    SpellCheckerSession.SpellCheckerSessionListener {

    private ActivitySpellCheckerBinding mBinding;
    private static final int NOT_A_LENGTH = -1;
    private SpellCheckerSession mScs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_spell_checker);
        mBinding.setActivity(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        final TextServicesManager tsm = (TextServicesManager) getSystemService(
            Context.TEXT_SERVICES_MANAGER_SERVICE);
        mScs = tsm.newSpellCheckerSession(null, null, this, true);
    }
    @Override
    public void onPause() {
        super.onPause();
        if (mScs != null) {
            mScs.close();
        }
    }

    public void go() {
        Toast.makeText(getApplicationContext(), mBinding.editText1.getText().toString(),
            Toast.LENGTH_SHORT).show();
        mScs.getSuggestions(new TextInfo(mBinding.editText1.getText().toString()), 10);
    }

    @Override
    public void onGetSuggestions(SuggestionsInfo[] suggestionsInfos) {
        final StringBuilder sb = new StringBuilder();
        for (SuggestionsInfo suggestionsInfo : suggestionsInfos) {
            final int len = suggestionsInfo.getSuggestionsCount();
            sb.append("\n");
            for (int j = 0; j < len; ++j) {
                sb.append(",").append(suggestionsInfo.getSuggestionAt(j));
            }
            sb.append(" (").append(len).append(") ");
        }

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mBinding.main.append(sb.toString());
            }
        });
    }

    @Override
    public void onGetSentenceSuggestions(SentenceSuggestionsInfo[] sentenceSuggestionsInfos) {
    }
}
