package app.andtut.notifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;

import app.andtut.R;
import app.andtut.databinding.ActivityNotificationBinding;

public class NotificationActivity extends AppCompatActivity {

    private NotificationManager mNotificationManager;
    private int notificationId = 100;
    private int numMessages = 0;

    private ActivityNotificationBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_notification);

        mBinding.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayNotification();
            }
        });

        mBinding.cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelNotification();
            }
        });

        mBinding.updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateNotification();
            }
        });
    }

    protected void displayNotification() {
        Log.i("Start", "notification");

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);

        mBuilder.setContentTitle("New Message");
        mBuilder.setContentText("You've received new message.");
        mBuilder.setTicker("New Message Alert");
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);

        mBuilder.setNumber(++numMessages);

        Intent resultIntent = new Intent(this, NotificationView.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(NotificationView.class);

        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(
                0,
                PendingIntent.FLAG_UPDATE_CURRENT
        );

        mBuilder.setContentIntent(resultPendingIntent);
        mBuilder.setAutoCancel(true);

        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(notificationId, mBuilder.build());
    }

    protected void cancelNotification() {
        Log.i("Cancel", "notification");
        mNotificationManager.cancel(notificationId);
    }

    protected void updateNotification() {
        Log.i("Update", "notification");
        displayNotification();
    }
}
