package app.andtut.alertdialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import app.andtut.R;
import app.andtut.databinding.ActivityAlertDialogBinding;

public class AlertDialogActivity extends AppCompatActivity {

    private ActivityAlertDialogBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_alert_dialog);
        mBinding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAlert();
            }
        });
    }

    private void openAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Decision");
        builder.setPositiveButton("positive", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getBaseContext(), "positive", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("negative", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getBaseContext(), "negative", Toast.LENGTH_SHORT).show();
            }
        });

//        builder.show();

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
