package imedtracker.csci3300.csci.mccb.ung.edu.imedtracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SettingsController extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_view);
        setTitle("Settings");
    }
}
