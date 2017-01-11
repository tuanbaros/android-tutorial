package app.andtut.internalstorage;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import app.andtut.R;
import app.andtut.databinding.ActivityInternalStorageBinding;

public class InternalStorageActivity extends AppCompatActivity {

    private ActivityInternalStorageBinding mBinding;

    private String data;
    private String file = "mydata";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_internal_storage);
        mBinding.setActivity(this);
    }

    public void save(){
        data = mBinding.editText1.getText().toString();
        try {
            FileOutputStream fOut = openFileOutput(file,MODE_WORLD_READABLE);
            fOut.write(data.getBytes());
            fOut.close();
            Toast.makeText(getBaseContext(),"file saved",
                Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void read(){
        try{
            FileInputStream fin = openFileInput(file);
            int c;
            String temp="";
            while( (c = fin.read()) != -1){
                temp = temp + Character.toString((char)c);
            }
            mBinding.editText1.setText(temp);
            Toast.makeText(getBaseContext(),"file read",
                Toast.LENGTH_SHORT).show();
        }catch(Exception e){

        }
    }
}
