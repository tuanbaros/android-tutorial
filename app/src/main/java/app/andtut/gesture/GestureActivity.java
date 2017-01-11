package app.andtut.gesture;

import android.databinding.DataBindingUtil;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

import app.andtut.R;
import app.andtut.databinding.ActivityGestureBinding;

public class GestureActivity extends AppCompatActivity {

    private ActivityGestureBinding mBinding;

    private Matrix matrix = new Matrix();
    private float scale = 1f;
    private ScaleGestureDetector SGD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_gesture);

        SGD = new ScaleGestureDetector(this,new ScaleListener());
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        SGD.onTouchEvent(ev);
        return true;
    }

    private class ScaleListener extends ScaleGestureDetector.
        SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scale *= detector.getScaleFactor();
            scale = Math.max(0.1f, Math.min(scale, 5.0f));
            matrix.setScale(scale, scale);
            mBinding.imageView1.setImageMatrix(matrix);
            return true;
        }
    }
}
