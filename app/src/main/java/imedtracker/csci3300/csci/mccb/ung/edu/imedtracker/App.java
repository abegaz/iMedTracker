package imedtracker.csci3300.csci.mccb.ung.edu.imedtracker;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {
    public static final String doseChannelID = "Dose Channel";
    public static final String alarmChannelID = "Alarm Channel";


    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannels();
    }

    private void createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel doseChannel = new NotificationChannel(
                    doseChannelID,
                    "Low Dose Count Alerts",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            doseChannel.setDescription("This is the dose notification channel.");

            NotificationChannel alarmChannel = new NotificationChannel(
                    alarmChannelID,
                    "Medication Alarms",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            alarmChannel.setDescription("This is the alarm notification channel.");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(doseChannel);
            manager.createNotificationChannel(alarmChannel);
        }
    }
}
