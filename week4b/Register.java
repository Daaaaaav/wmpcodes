package com.example.sharedpreferences;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    private EditText addUser, addPassword, addConfirmPassword, addAddress, addPhone;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        addUser = findViewById(R.id.username);
        addPassword = findViewById(R.id.password);
        addConfirmPassword = findViewById(R.id.confirm_password);
        addAddress = findViewById(R.id.address);
        addPhone = findViewById(R.id.phone);

        addConfirmPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_NULL) {
                    validate();
                    return true;
                }
                return false;
            }
        });

        btnSignUp = findViewById(R.id.button3);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });
    }

    private void validate() {
        addUser.setError(null);
        addPassword.setError(null);
        addConfirmPassword.setError(null);
        addAddress.setError(null);
        addPhone.setError(null);
        View focus = null;
        boolean cancel = false;

        String username = addUser.getText().toString();
        String password = addPassword.getText().toString();
        String confirm_password = addConfirmPassword.getText().toString();
        String address = addAddress.getText().toString();
        String phone = addPhone.getText().toString();

        if (TextUtils.isEmpty(username)) {
            addUser.setError("This field is required");
            focus = addUser;
            cancel = true;
        } else if (!checkUsername(username)) {
            addUser.setError("This username already exists");
            focus = addUser;
            cancel = true;
        }

        if (TextUtils.isEmpty(password)) {
            addPassword.setError("This field is required");
            focus = addPassword;
            cancel = true;
        } else if (!checkPassword(password, confirm_password)) {
            addPassword.setError("Confirm Password is wrong");
            focus = addConfirmPassword;
            cancel = true;
        }

        if (TextUtils.isEmpty(address)) {
            addAddress.setError("This field is required");
            focus = addAddress;
            cancel = true;
        }

        if (TextUtils.isEmpty(phone)) {
            addPhone.setError("This field is required");
            focus = addPhone;
            cancel = true;
        }

        if (cancel) {
            focus.requestFocus();
        } else {
            Preferences.setUsername(getBaseContext(), username);
            Preferences.setPassword(getBaseContext(), password);
            Preferences.setAddress(getBaseContext(), address);
            Preferences.setPhoneNumber(getBaseContext(), phone);
            finish();
        }
    }

    private boolean checkUsername(String user) {
        return !user.equals(Preferences.getUsername(getBaseContext()));
    }

    private boolean checkPassword(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }
}
