package app.andtut.multitouch;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

import app.andtut.R;
import app.andtut.databinding.ActivityMultiTouchBinding;

public class MultiTouchActivity extends AppCompatActivity {

    private ActivityMultiTouchBinding mBinding;
    float xAxis = 0f;
    float yAxis = 0f;
    private EventTouch mEventTouch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_multi_touch);
        mEventTouch = new EventTouch();
        mBinding.setEventTouch(mEventTouch);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev){
        final int actionPeformed = ev.getAction();
        switch(actionPeformed){
            case MotionEvent.ACTION_DOWN:{
                final float x = ev.getX();
                final float y = ev.getY();
                mEventTouch.setLastXAxis(x);
                mEventTouch.setLastYAxis(y);
                break;
            }
            case MotionEvent.ACTION_MOVE:{
                final float x = ev.getX();
                final float y = ev.getY();
                final float dx = x - mEventTouch.getLastXAxis();
                final float dy = y - mEventTouch.getLastYAxis();
                xAxis += dx;
                yAxis += dy;
                mEventTouch.setXAxis(xAxis);
                mEventTouch.setYAxis(yAxis);
                break;
            }
        }
        return true;
    }
}
