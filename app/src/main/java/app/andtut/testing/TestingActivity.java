package app.andtut.testing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import app.andtut.R;

public class TestingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);
    }


    public void activity2(View view){
        Intent intent = new Intent(this, TestActivity.class);
        startActivity(intent);
    }
}
