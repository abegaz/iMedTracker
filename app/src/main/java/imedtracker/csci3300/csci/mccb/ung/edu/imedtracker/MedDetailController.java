package imedtracker.csci3300.csci.mccb.ung.edu.imedtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MedDetailController extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.med_detail_view);
        Intent intent = getIntent();
        String medName = intent.getStringExtra("medName");
        String doseCount = intent.getStringExtra("doseCount");
        String doseFrequency = intent.getStringExtra("doseFrequency");
        TextView lblMedName = findViewById(R.id.lblMedName);
        TextView lblDoseCount = findViewById(R.id.lblDoseCount);
        TextView lblDoseFrequency = findViewById(R.id.lblDoseFrequency);
        lblMedName.setText(medName);
        lblDoseCount.setText(doseCount);
        lblDoseFrequency.setText(doseFrequency);
    }
}
