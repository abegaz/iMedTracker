package imedtracker.csci3300.csci.mccb.ung.edu.imedtrackermaster;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpController extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_view);
    }

    public void touchLogin(View view) {
        Intent loginIntent = new Intent(this, LogInController.class);
        startActivity(loginIntent);
    }

    public void touchRegisterUser(View view) {
        UserModel user = new UserModel();
        DatabaseHelper dbUser = new DatabaseHelper(this);
        EditText txtFirstName = findViewById(R.id.txtFirstName);
        EditText txtLastName = findViewById(R.id.txtLastName);
        EditText txtPassword =  findViewById(R.id.txtPassword);
        EditText txtEmail =  findViewById(R.id.txtEmail);
        user.setFirstName(txtFirstName.getText().toString());
        user.setLastName(txtLastName.getText().toString());
        user.setPassword(txtPassword.getText().toString());
        user.setEmail(txtEmail.getText().toString());
        Boolean isAdded = dbUser.insertUser(user);
        if (isAdded) {
            Toast.makeText(this, "User is registered successfully.", Toast.LENGTH_LONG).show();
            //An Intent is a messaging object you can use to request an action from another app component.
            Intent intent = new Intent(this, LogInController.class);
            startActivity(intent);
        }
    }
}