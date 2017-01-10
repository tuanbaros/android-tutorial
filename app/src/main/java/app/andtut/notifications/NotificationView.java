package app.andtut.notifications;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import app.andtut.R;
import app.andtut.databinding.NotificationBinding;

public class NotificationView extends AppCompatActivity {

    private NotificationBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.notification);
    }
}
