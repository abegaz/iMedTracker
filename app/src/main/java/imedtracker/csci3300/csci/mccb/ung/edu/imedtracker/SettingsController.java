package imedtracker.csci3300.csci.mccb.ung.edu.imedtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SettingsController extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_view);
        setTitle("Settings");
    }

    public void touchChangePass(View view) {
        Intent changePassIntent = new Intent(this, ChangePassController.class);
        startActivity(changePassIntent);
    }
}
