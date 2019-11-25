package com.mitsko.poputka.view;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

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
                    photo = imageReturnedIntent.getData();
                    imageView.setImageURI(photo);
                }
        }
    }

    public void reg(View view) {
        String email = getIntent().getExtras().getString("email");
        String password = getIntent().getExtras().getString("password");

        EditText editText = findViewById(R.id.editText11);

        UserController controller = UserControllerImpl.getInstance();
        controller.createUser(email, password, editText.getText().toString(), photo);

        Intent intent = new Intent(ProfileWindow.this, MenuWindow.class);
        startActivity(intent);
    }

    public void goBack(View view) {
        finish();
    }
}
