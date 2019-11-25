package com.mitsko.poputka.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.mitsko.poputka.R;

public class RegistrationWindow extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_window);
    }

    public void regNext(View view) {
        EditText email = findViewById(R.id.emailText);
        EditText password = findViewById(R.id.passwordText);
        EditText againPassword = findViewById(R.id.againPasswordText);

        if (email.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Вы не ввели адрес электронной почты"
                    , Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Вы не ввели пароль"
                    , Toast.LENGTH_SHORT).show();
            return;
        }
        if (againPassword.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Вы не ввели пароль повторно"
                    , Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.getText().equals(againPassword.getText())) {
            Toast.makeText(getApplicationContext(), "Ваши введённые пароли не совпадают"
                    , Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.getText().toString().length() < 5) {
            Toast.makeText(getApplicationContext(), "Ваш пароль слишком лёгкий"
                    , Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(RegistrationWindow.this, ProfileWindow.class);
        intent.putExtra("email", email.getText().toString());
        intent.putExtra("password", password.getText().toString());
        startActivity(intent);
    }

    public void goBack(View view) {
        finish();
    }
}
