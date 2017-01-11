package app.andtut.imageeffect;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import app.andtut.R;
import app.andtut.databinding.ActivityImageEffectBinding;

public class ImageEffectActivity extends AppCompatActivity {

    private ActivityImageEffectBinding mBinding;

    private Bitmap bmp;
    private Bitmap operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_image_effect);
        mBinding.setActivity(this);

        BitmapDrawable abmp = (BitmapDrawable) mBinding.imageView1.getDrawable();
        bmp = abmp.getBitmap();
    }

    public void gray(){
        operation= Bitmap.createBitmap(bmp.getWidth(),
            bmp.getHeight(),bmp.getConfig());
        double red = 0.33;
        double green = 0.59;
        double blue = 0.11;
        for(int i=0; i<bmp.getWidth(); i++){
            for(int j=0; j<bmp.getHeight(); j++){
                int p = bmp.getPixel(i, j);
                int r = Color.red(p);
                int g = Color.green(p);
                int b = Color.blue(p);
                r = (int) red * r;
                g = (int) green * g;
                b = (int) blue * b;
                operation.setPixel(i, j, Color.argb(Color.alpha(p), r, g, b));
            }
        }
        mBinding.imageView1.setImageBitmap(operation);
    }

    public void bright(){
        operation= Bitmap.createBitmap(bmp.getWidth(),
            bmp.getHeight(),bmp.getConfig());
        for(int i=0; i<bmp.getWidth(); i++){
            for(int j=0; j<bmp.getHeight(); j++){
                int p = bmp.getPixel(i, j);
                int r = Color.red(p);
                int g = Color.green(p);
                int b = Color.blue(p);
                int alpha = Color.alpha(p);
                r = 100 + r;
                g = 100 + g;
                b = 100 + b;
                alpha = 100 + alpha;
                operation.setPixel(i, j, Color.argb(alpha, r, g, b));
            }
        }
        mBinding.imageView1.setImageBitmap(operation);
    }

    public void dark(){
        operation= Bitmap.createBitmap(bmp.getWidth(),
            bmp.getHeight(),bmp.getConfig());
        for(int i=0; i<bmp.getWidth(); i++){
            for(int j=0; j<bmp.getHeight(); j++){
                int p = bmp.getPixel(i, j);
                int r = Color.red(p);
                int g = Color.green(p);
                int b = Color.blue(p);
                int alpha = Color.alpha(p);
                r = r - 50;
                g = g - 50;
                b = b - 50;
                alpha = alpha -50;
                operation.setPixel(i, j, Color.argb(Color.alpha(p), r, g, b));
            }
        }
        mBinding.imageView1.setImageBitmap(operation);
    }
}
