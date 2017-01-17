package app.andtut.textureview;

import android.Manifest;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.widget.FrameLayout;

import com.lalosoft.easypermission.EasyPermissionActivity;
import com.lalosoft.easypermission.RegisterPermission;

import java.io.IOException;

import app.andtut.R;

@RegisterPermission(permissions = {Manifest.permission.CAMERA})
public class TextureViewActivity extends EasyPermissionActivity implements
    TextureView.SurfaceTextureListener {

    private TextureView myTexture;
    private Camera mCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texture_view);
        myTexture = new TextureView(this);
        myTexture.setSurfaceTextureListener(this);
        setContentView(myTexture);

    }

    @Override
    public void onRequestPermissionGranted(String[] permission, int[] grantResults) {
        Log.i("permission", "granted");
    }

    @Override
    public void onRequestPermissionDenied(String[] permission, int[] grantResults) {
        Log.i("permission", "denied");
    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture arg0, int arg1,
                                          int arg2) {
        mCamera = Camera.open();
        Camera.Size previewSize = mCamera.getParameters().getPreviewSize();
        myTexture.setLayoutParams(new FrameLayout.LayoutParams(
            previewSize.width, previewSize.height, Gravity.CENTER));
        try {
            mCamera.setPreviewTexture(arg0);
        } catch (IOException t) {
        }
        mCamera.startPreview();
        myTexture.setAlpha(1.0f);
        myTexture.setRotation(90.0f);
    }
    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture arg0) {
        mCamera.stopPreview();
        mCamera.release();
        return true;
    }
    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture arg0, int arg1,
                                            int arg2) {
        // TODO Auto-generated method stub
    }
    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture arg0) {
        // TODO Auto-generated method stub
    }
}
