package imedtracker.csci3300.csci.mccb.ung.edu.imedtrackermaster;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class AddMedController extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {
    int freqValue;
    Calendar c = Calendar.getInstance();

    private TextView txtAlarmTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_med_view);
        setTitle("Add New Medication");

        txtAlarmTime = findViewById(R.id.txtAlarmTime);

        Button alarmButton = findViewById(R.id.alarmButton);
        alarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "Time Picker");
            }
        });

    }

   @Override
    public void onTimeSet(TimePicker view, int selectedHour, int selectedMin) {
        c.set(Calendar.HOUR_OF_DAY, selectedHour);
        c.set(Calendar.MINUTE, selectedMin);
        c.set(Calendar.SECOND, 0);

        updateTimeText(c);
    }

    public void updateTimeText(Calendar c) {
        String timeText = "Alarm set for: ";
        timeText += DateFormat.getTimeInstance(DateFormat.SHORT).format(c.getTime());

        txtAlarmTime.setText(timeText);
    }

    public void startAlarm(Calendar c) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

        if (c.before(Calendar.getInstance())) {
            c.add(Calendar.DATE, 1);
        }

        alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);
    }

    public void touchAddMed(View view) {
        PillModel pill = new PillModel();
        DatabaseHelper dbPill = new DatabaseHelper(this);
        EditText txtPillName = findViewById(R.id.txtPillName);
        EditText txtDoseCount = findViewById(R.id.txtDoseCount);
        Spinner spinnerFrequency = findViewById(R.id.doseFrequency);
        switch (spinnerFrequency.getSelectedItem().toString())
        {
            case "1 Hour":
            {
                freqValue = 1;
                break;
            }
            case "2 Hours":
            {
                freqValue = 2;
                break;
            }
            case "3 Hours":
            {
                freqValue = 3;
                break;
            }
            case "4 Hours":
            {
                freqValue = 4;
                break;
            }
            case "5 Hours":
            {
                freqValue = 5;
                break;
            }
            case "6 Hours":
            {
                freqValue = 6;
                break;
            }
            case "8 Hours":
            {
                freqValue = 8;
                break;
            }
            case "10 Hours":
            {
                freqValue = 10;
                break;
            }
            case "12 Hours":
            {
                freqValue = 12;
                break;
            }
            case "1 Day":
            {
                freqValue = 24;
                break;
            }
            case "2 Days":
            {
                freqValue = 48;
                break;
            }
            case "3 Days":
            {
                freqValue = 72;
                break;
            }
            case "4 Days":
            {
                freqValue = 96;
                break;
            }
            case "1 Week":
            {
                freqValue = 168;
                break;
            }
            case "2 Weeks":
            {
                freqValue = 336;
                break;
            }
        }

        pill.setPillName(txtPillName.getText().toString());
        pill.setDoseCount(Integer.parseInt(txtDoseCount.getText().toString()));
        pill.setDoseFrequency(freqValue);

        startAlarm(c);

        Boolean isAdded = dbPill.insertPill(pill);
        if (isAdded) {
            Toast.makeText(this, "Pill is added successfully.", Toast.LENGTH_LONG).show();
            Intent navIntent = new Intent(this, NavController.class);
            startActivity(navIntent);
        }
        else {
            Toast.makeText(this, "Something went wrong.", Toast.LENGTH_LONG).show();
        }
    }
}

