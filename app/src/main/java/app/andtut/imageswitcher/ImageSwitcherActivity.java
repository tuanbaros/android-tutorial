package app.andtut.imageswitcher;

import android.databinding.DataBindingUtil;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import app.andtut.R;
import app.andtut.databinding.ActivityImageSwitcherBinding;

public class ImageSwitcherActivity extends AppCompatActivity {

    private ActivityImageSwitcherBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_image_switcher);
        mBinding.setActivity(this);
        mBinding.imageSwitcher1.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView myView = new ImageView(getApplicationContext());
                myView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                myView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.
                    FILL_PARENT, ActionBar.LayoutParams.FILL_PARENT));
                return myView;
            }
        });
    }

    public void next(){
        Toast.makeText(getApplicationContext(), "Next Image",
            Toast.LENGTH_LONG).show();
        Animation in = AnimationUtils.loadAnimation(this,
            android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this,
            android.R.anim.slide_out_right);
        mBinding.imageSwitcher1.setInAnimation(in);
        mBinding.imageSwitcher1.setOutAnimation(out);
        mBinding.imageSwitcher1.setImageResource(R.mipmap.ic_launcher);
    }
    public void previous(){
        Toast.makeText(getApplicationContext(), "previous Image",
            Toast.LENGTH_LONG).show();
        Animation in = AnimationUtils.loadAnimation(this,
            android.R.anim.slide_out_right);
        Animation out = AnimationUtils.loadAnimation(this,
            android.R.anim.slide_in_left);
        mBinding.imageSwitcher1.setInAnimation(out);
        mBinding.imageSwitcher1.setOutAnimation(in);
        mBinding.imageSwitcher1.setImageResource(R.mipmap.ic_launcher);
    }
}
