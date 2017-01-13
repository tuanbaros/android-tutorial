package app.andtut.notifications;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import app.andtut.R;
import app.andtut.databinding.ActivityPushNotificationBinding;

public class PushNotificationActivity extends Activity {

    private ActivityPushNotificationBinding mBinding;

    private NotificationManager mNotificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_push_notification);
        mBinding.setActivity(this);
    }

    public void push() {
        String title = mBinding.titleEditText.getText().toString();
        String subject = mBinding.headingEditText.getText().toString();
        String body = mBinding.bodyEditText.getText().toString();
        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder notify = new Notification.Builder(this);
        PendingIntent pending = PendingIntent.getActivity(
            getApplicationContext(), 0, new Intent(this, NotificationView.class), 0);
        notify.setSmallIcon(android.R.drawable.sym_def_app_icon);
        notify.setTicker(subject);
        notify.setContentTitle(title);
        notify.setSubText(subject);
        notify.setContentText(body);
        notify.setContentIntent(pending);
//        notify.setLatestEventInfo(getApplicationContext(), subject, body, pending);
        mNotificationManager.notify(0, notify.build());
    }
}
