package imedtracker.csci3300.csci.mccb.ung.edu.imedtrackermaster;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LogInController extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in_view);
    }

    public void touchSignUp(View view) {
        Intent signUpIntent = new Intent(this, SignUpController.class);
        startActivity(signUpIntent);
    }

    public void touchLogIn(View view) {
        UserModel user = new UserModel();
        DatabaseHelper dbUser = new DatabaseHelper(this);
        EditText txtEmail = findViewById(R.id.txtEmail);
        EditText txtPassword = findViewById(R.id.txtPassword);
        String email = txtEmail.getText().toString();
        String password = txtPassword.getText().toString();
        user.setEmail(email);
        user.setPassword(password);
        Boolean isAdded = dbUser.getLoginInfo(user);
        if(!email.isEmpty() || !password.isEmpty()) {
            if (isAdded) {
                Toast.makeText(this, "User log in successful.", Toast.LENGTH_LONG).show();
                Log.d("Login", "Login is successful.");
                //An Intent is a messaging object you can use to request an action from another app component.
                Intent intent = new Intent(this, NavController.class);
                startActivity(intent);
            }
            else
            {
                Toast.makeText(this, "Wrong email or password, please try again.", Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(this, "Please input an email and password.", Toast.LENGTH_LONG).show();
        }
    }
}