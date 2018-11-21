package imedtracker.csci3300.csci.mccb.ung.edu.imedtracker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class TakeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Medication taken.", Toast.LENGTH_LONG).show();


    }
}
