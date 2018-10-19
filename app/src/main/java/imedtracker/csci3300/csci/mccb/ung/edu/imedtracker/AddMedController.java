package imedtracker.csci3300.csci.mccb.ung.edu.imedtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddMedController extends AppCompatActivity {
    int freqValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_med_view);
        setTitle("Add New Medication");
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
            }
            case "2 Hours":
            {
                freqValue = 2;
            }
            case "3 Hours":
            {
                freqValue = 3;
            }
            case "4 Hours":
            {
                freqValue = 4;
            }
            case "5 Hours":
            {
                freqValue = 5;
            }
            case "6 Hours":
            {
                freqValue = 6;
            }
            case "8 Hours":
            {
                freqValue = 8;
            }
            case "10 Hours":
            {
                freqValue = 10;
            }
            case "12 Hours":
            {
                freqValue = 12;
            }
            case "1 Day":
            {
                freqValue = 24;
            }
            case "2 Days":
            {
                freqValue = 48;
            }
            case "3 Days":
            {
                freqValue = 72;
            }
            case "4 Days":
            {
                freqValue = 96;
            }
            case "1 Week":
            {
                freqValue = 168;
            }
            case "2 Weeks":
            {
                freqValue = 336;
            }
        }
        pill.setPillName(txtPillName.getText().toString());
        pill.setDoseCount(Integer.parseInt(txtDoseCount.getText().toString()));
        pill.setDoseFrequency(freqValue);
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

