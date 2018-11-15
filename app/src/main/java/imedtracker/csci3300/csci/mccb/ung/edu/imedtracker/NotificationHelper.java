package imedtracker.csci3300.csci.mccb.ung.edu.imedtracker;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class NotificationHelper extends ContextWrapper {
    public static final String alarmID = "alarmID";
    public static final String alarmName = "Medication Alarm";
    public static final String lowDoseID = "lowDoseID";
    public static final String lowDoseName = "Medication Alert";

    private NotificationManager manager;

    public NotificationHelper(Context base) {
        super(base);
        createChannels();
    }

    private void createChannels() {
        NotificationChannel notificationChannel = new NotificationChannel(alarmID, alarmName, NotificationManager.IMPORTANCE_DEFAULT);
        notificationChannel.enableLights(true);
        notificationChannel.enableVibration(true);
        notificationChannel.setLightColor(R.color.colorPrimary);
        notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(notificationChannel);
    }

    public NotificationManager getManager() {
        if (manager == null) {
            manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return manager;
    }

    public NotificationCompat.Builder getAlarmChannelNotification(String title, String message) {

        Intent activityIntent = new Intent(this, LogInController.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this,
                0, activityIntent, 0);

        Intent takeIntent = new Intent("Take");
        Intent snoozeIntent = new Intent("Snooze");

        PendingIntent takePendingIntent = PendingIntent.getBroadcast(this,
                2, takeIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        PendingIntent snoozePendingIntent = PendingIntent.getBroadcast(this,
                2, snoozeIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        return new NotificationCompat.Builder(getApplicationContext(), alarmID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.BLUE)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .addAction(R.mipmap.ic_launcher, "Take", takePendingIntent)
                .addAction(R.mipmap.ic_launcher, "Snooze", snoozePendingIntent);

    }

    public NotificationCompat.Builder getLowDoseChannelNotification(String title, String message) {

        Intent activityIntent = new Intent(this, LogInController.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this,
                0, activityIntent, 0);

        Intent okIntent = new Intent("Ok");

        PendingIntent okPendingIntent = PendingIntent.getBroadcast(this,
                2, okIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        return new NotificationCompat.Builder(getApplicationContext(), alarmID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.BLUE)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .addAction(R.mipmap.ic_launcher, "Ok", okPendingIntent);

    }
}
