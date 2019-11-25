package com.mitsko.poputka.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.mitsko.poputka.R;
import com.mitsko.poputka.controller.UserController;
import com.mitsko.poputka.controller.impl.UserControllerImpl;

public class EnterWindow extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_window);
    }

    public void signIn(View view) {
        EditText email = findViewById(R.id.emailEnterText);
        EditText password = findViewById(R.id.passwordEnterText);

        if (email.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Вы не ввели адрес своей электронной почты"
                    , Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Вы не ввели пароль"
                    , Toast.LENGTH_SHORT).show();
            return;
        }

        UserController controller = UserControllerImpl.getInstance();
        controller.signIn(email.getText().toString(), password.getText().toString());

        Intent intent = new Intent(EnterWindow.this, MenuWindow.class);
        startActivity(intent);
    }

    public void goBack(View view) {
        finish();
    }
}
