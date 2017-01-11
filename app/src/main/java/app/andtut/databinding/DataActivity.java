package app.andtut.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import app.andtut.R;

public class DataActivity extends AppCompatActivity {

    private ActivityDataBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_data);
        User user = new User("Demo", "User", true);
        mBinding.setUser(user);
        mBinding.setHandlers(new MyHandlers());
        mBinding.setPresenter(new Presenter());
    }
}
