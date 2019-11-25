package com.mitsko.poputka.view;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.mitsko.poputka.R;
import com.mitsko.poputka.controller.UserController;
import com.mitsko.poputka.controller.impl.UserControllerImpl;

public class ProfileWindow extends Activity {
    private static final int GALLERY_REQUEST = 1;
    private Uri photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_window);
    }

    public void addPhoto(View view) {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, GALLERY_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        ImageView imageView = (ImageView) findViewById(R.id.imageView2);

        switch (requestCode) {
            case GALLERY_REQUEST:
                if (resultCode == RESULT_OK) {
                    //Uri selectedImage = imageReturnedIntent.getData();
                    photo = imageReturnedIntent.getData();
                    //imageView.setImageURI(selectedImage);
                    imageView.setImageURI(photo);
                }
        }
    }

    public void reg(View view) {
        String email = getIntent().getExtras().getString("email");
        String password = getIntent().getExtras().getString("password");

        //ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        EditText editText = findViewById(R.id.editText11);
        /*User user = new User();
        user.setId("01");
        user.getProfile().setPhoto(photo);
        user.getProfile().setName(editText.getText().toString());*/

        //Controller controller = Controller.getInstance(email, password
        //, editText.getText().toString(), photo);//new Controller(email, password, editText.getText().toString(), photo);

        UserController controller = UserControllerImpl.getInstance();//Controller controller = Controller.getInstance();
        controller.createUser(email, password, editText.getText().toString(), photo);

        Intent intent = new Intent(ProfileWindow.this, MenuWindow.class);
        startActivity(intent);

        //UserDAO userDAO = new UserFirebaseDAOImpl();

        // userDAO.signOut();//??????????????????????????????????????????/

        /*if(userDAO.addUser(email, password, user)){
            editText.setText("Ura");
            Intent intent = new Intent(ProfileWindow.this, MenuWindow.class);
            startActivity(intent);
        }else {
            editText.setText("Loh");
            /*Toast.makeText(getApplicationContext(), "Error"
                    , Toast.LENGTH_SHORT).show();
        }*/
        //editText.setText(userDAO.addUser(email, password, user));
    }

    public void goBack(View view) {
        finish();
    }
}
