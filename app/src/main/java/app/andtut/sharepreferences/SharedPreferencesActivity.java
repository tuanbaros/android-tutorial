package app.andtut.sharepreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import app.andtut.R;
import app.andtut.databinding.ActivitySharedPreferencesBinding;

public class SharedPreferencesActivity extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs";
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";
    public static final String Street = "streetKey";
    public static final String Place = "placeKey";

    private ActivitySharedPreferencesBinding mBinding;

    private SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_shared_preferences);
        mBinding.setActivity(this);

        sharedpreferences = getSharedPreferences(MyPREFERENCES,
            Context.MODE_PRIVATE);
        if (sharedpreferences.contains(Name))
        {
            mBinding.editTextName.setText(sharedpreferences.getString(Name, ""));
        }
        if (sharedpreferences.contains(Phone))
        {
            mBinding.editTextPhone.setText(sharedpreferences.getString(Phone, ""));
        }
        if (sharedpreferences.contains(Email))
        {
            mBinding.editTextEmail.setText(sharedpreferences.getString(Email, ""));
        }
        if (sharedpreferences.contains(Street))
        {
            mBinding.editTextStreet.setText(sharedpreferences.getString(Street, ""));
        }
        if (sharedpreferences.contains(Place))
        {
            mBinding.editTextCity.setText(sharedpreferences.getString(Place, ""));
        }
    }

    public void run() {
        String n = mBinding.editTextName.getText().toString();
        String ph = mBinding.editTextPhone.getText().toString();
        String e = mBinding.editTextEmail.getText().toString();
        String s = mBinding.editTextStreet.getText().toString();
        String p = mBinding.editTextCity.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Name, n);
        editor.putString(Phone, ph);
        editor.putString(Email, e);
        editor.putString(Street, s);
        editor.putString(Place, p);
        editor.apply();
    }
}
