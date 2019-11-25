package com.mitsko.poputka; //tratata

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mitsko.poputka.controller.UserController;
import com.mitsko.poputka.controller.impl.UserControllerImpl;
import com.mitsko.poputka.view.EnterWindow;
import com.mitsko.poputka.view.MenuWindow;
import com.mitsko.poputka.view.RegistrationWindow;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserController controller = UserControllerImpl.getInstance();
        if (controller.isSignIn()) {
            Intent intent = new Intent(MainActivity.this, MenuWindow.class);
            startActivity(intent);
        } else {
            setContentView(R.layout.activity_main);
        }
    }

    public void registration(View view) {
        Intent intent = new Intent(MainActivity.this, RegistrationWindow.class);
        startActivity(intent);
    }

    public void enter(View view) {
        Intent intent = new Intent(MainActivity.this, EnterWindow.class);
        startActivity(intent);
    }
}
