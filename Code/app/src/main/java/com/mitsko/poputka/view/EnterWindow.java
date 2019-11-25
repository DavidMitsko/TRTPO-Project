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
            Toast.makeText(getApplicationContext(), "Please, enter your email"
                    , Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Please, enter your password"
                    , Toast.LENGTH_SHORT).show();
            return;
        }

        /*SignInInfo signInInfo = new SignInInfo(email.getText().toString()
                , password.getText().toString());*/

        UserController controller = UserControllerImpl.getInstance();
        controller.signIn(email.getText().toString(), password.getText().toString());

        Intent intent = new Intent(EnterWindow.this, MenuWindow.class);
        startActivity(intent);
        //UserDAO userDAO = new UserFirebaseDAOImpl();

        //userDAO.signOut();

         /*String user = userDAO.signInUser(email.getText().toString()
                 , password.getText().toString());
         if(user.equals("sign in")){
             email.setText("cool");
             /*Intent intent = new Intent(EnterWindow.this, MenuWindow.class);
             startActivity(intent);
         } else if(user.equals("error")){
           //email.setText("loh");
             Toast.makeText(getApplicationContext(), "Error"
                     , Toast.LENGTH_SHORT).show();
         }else if(user.equals("xz")){
             email.setText(user);
         } else if(user.equals("exist")){
             email.setText(user);
         }*/
    }

    public void goBack(View view) {
        finish();
    }
}
