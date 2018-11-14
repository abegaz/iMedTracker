package imedtracker.csci3300.csci.mccb.ung.edu.imedtracker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class AlertReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationHelper notificationHelper = new NotificationHelper(context);
        NotificationCompat.Builder nb = notificationHelper.getAlarmChannelNotification("Medication Alarm", "It's time to take your medication.");
        notificationHelper.getManager().notify(1, nb.build());
    }
}
