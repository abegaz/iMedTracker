package imedtracker.csci3300.csci.mccb.ung.edu.imedtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePassController extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_pass_view);
        setTitle("Change Password");
    }

    public void touchChangePassword(View view) {
        UserModel user = new UserModel();
        DatabaseHelper dbUser = new DatabaseHelper(this);

        EditText firstName = findViewById(R.id.firstName);
        EditText lastName = findViewById(R.id.lastName);
        EditText userEmail = findViewById(R.id.userEmail);
        EditText oldPass = findViewById(R.id.oldPass);
        EditText newPass = findViewById(R.id.newPass);

        String first = firstName.getText().toString();
        String last = lastName.getText().toString();
        String email = userEmail.getText().toString();
        String oldPassword = oldPass.getText().toString();
        String newPassword = newPass.getText().toString();

        user.setFirstName(first);
        user.setLastName(last);
        user.setEmail(email);
        user.setPassword(newPassword);
        user.setOldPassword(oldPassword);

        Boolean isDeleted = dbUser.deleteInfo(user);

        if (isDeleted) {

            Boolean isAdded = dbUser.insertUser(user);

            if (!email.isEmpty() || !oldPassword.isEmpty() || !newPassword.isEmpty()) {
                if (isAdded) {
                    Toast.makeText(this, "Password change successful.", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, SettingsController.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Something went wrong.", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(this, "Please input all information.", Toast.LENGTH_LONG).show();
            }
        }
    }
}