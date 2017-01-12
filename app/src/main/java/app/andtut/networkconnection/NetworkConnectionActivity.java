package app.andtut.networkconnection;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import app.andtut.R;
import app.andtut.databinding.ActivityNetworkConnectionBinding;

public class NetworkConnectionActivity extends AppCompatActivity {

    private ActivityNetworkConnectionBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_network_connection);
        mBinding.setActivity(this);
        mBinding.urlEditText.setText("http://tutorialspoint.com/");
    }

    public void download(){
        String url = mBinding.urlEditText.getText().toString();
        new DownloadWebPage(this, mBinding.resultTextView).execute(url);
    }
}
