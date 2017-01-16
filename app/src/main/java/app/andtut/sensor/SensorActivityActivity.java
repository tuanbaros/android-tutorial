package app.andtut.sensor;

import android.databinding.DataBindingUtil;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import app.andtut.R;
import app.andtut.databinding.ActivitySensorBinding;

public class SensorActivityActivity extends AppCompatActivity {

    private ActivitySensorBinding mBinding;
    private SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_sensor);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List list = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        StringBuilder stringBuilder = new StringBuilder();
        for (Object object:
             list) {
            Sensor sensor = (Sensor) object;
            stringBuilder.append(sensor.getName()).append("\n");
            stringBuilder.append(sensor.getVendor()).append("\n");
            stringBuilder.append(sensor.getVersion()).append("\n");
        }
        mBinding.textView1.setText(stringBuilder);
    }
}
