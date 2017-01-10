package app.andtut.camera;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import app.andtut.R;
import app.andtut.databinding.ActivityCameraBinding;

public class CameraActivity extends AppCompatActivity {

    private ActivityCameraBinding mBinding;

    private Camera cameraObject;
    private ShowCamera showCamera;

    public static Camera isCameraAvailiable(){
        Camera object = null;
        try {
            object = Camera.open();
        } catch (Exception e){
        }
        return object;
    }

    private Camera.PictureCallback capturedIt = new Camera.PictureCallback() {
        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(data , 0, data .length);
            if(bitmap==null){
                Toast.makeText(getApplicationContext(), "not taken",
                    Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(), "taken",
                    Toast.LENGTH_SHORT).show();
            }
            cameraObject.release();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_camera);

        cameraObject = isCameraAvailiable();
        showCamera = new ShowCamera(this, cameraObject);
        mBinding.cameraPreview.addView(showCamera);

        mBinding.buttonCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cameraObject.takePicture(null, null, capturedIt);
            }
        });
    }

//    private void open() {
//        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
//        startActivityForResult(intent, 0);
//    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        // TODO Auto-generated method stub
//        super.onActivityResult(requestCode, resultCode, data);
//        Bitmap bp = (Bitmap) data.getExtras().get("data");
//        mBinding.imageView.setImageBitmap(bp);
//    }
}
