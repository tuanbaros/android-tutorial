package app.andtut.autocomplete;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;

import app.andtut.R;
import app.andtut.databinding.ActivityAutoCompleteBinding;

public class AutoCompleteActivity extends AppCompatActivity {

    private ActivityAutoCompleteBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_auto_complete);

        String[] countries = getResources().
                getStringArray(R.array.list_of_countries);
        ArrayAdapter adapter = new ArrayAdapter<>
                (this,android.R.layout.simple_list_item_1,countries);

        mBinding.autoCompleteTextView.setAdapter(adapter);
        mBinding.multiAutoCompleteTextView.setAdapter(adapter);

        mBinding.autoCompleteTextView.setThreshold(1);
        mBinding.multiAutoCompleteTextView.setThreshold(1);

        mBinding.multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

    }
}
