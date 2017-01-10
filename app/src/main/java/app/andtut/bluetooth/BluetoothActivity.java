package app.andtut.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

import app.andtut.R;
import app.andtut.databinding.ActivityBluetoothBinding;

public class BluetoothActivity extends AppCompatActivity {

    private ActivityBluetoothBinding mBinding;

    private BluetoothAdapter BA;
    private Set<BluetoothDevice> pairedDevices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_bluetooth);

        BA = BluetoothAdapter.getDefaultAdapter();
    }

    public void on(View view){
        if (!BA.isEnabled()) {
            Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(turnOn, 0);
            Toast.makeText(getApplicationContext(),"Turned on"
                ,Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"Already on",
                Toast.LENGTH_LONG).show();
        }
    }
    public void list(View view){
        pairedDevices = BA.getBondedDevices();
        ArrayList list = new ArrayList();
        for(BluetoothDevice bt : pairedDevices)
            list.add(bt.getName());
        Toast.makeText(getApplicationContext(),"Showing Paired Devices",
            Toast.LENGTH_SHORT).show();
        final ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, list);
        mBinding.listView.setAdapter(adapter);
    }
    public void off(View view){
        BA.disable();
        Toast.makeText(getApplicationContext(),"Turned off" ,
            Toast.LENGTH_LONG).show();
    }
    public void visible(View view){
        Intent getVisible = new Intent(BluetoothAdapter.
            ACTION_REQUEST_DISCOVERABLE);
        startActivityForResult(getVisible, 0);
    }
}
