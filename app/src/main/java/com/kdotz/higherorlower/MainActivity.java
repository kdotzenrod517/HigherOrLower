package com.kdotz.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateRandomNumber();
    }

    public void generateRandomNumber(){
        Random random = new Random();
        randomNumber = random.nextInt(20) + 1;
    }

    public void onClick(View view) {

        EditText guess = (EditText) findViewById(R.id.editText);
        Log.i("Entered Value", guess.getText().toString());
        Log.i("Random Number", Integer.toString(randomNumber));

        String message = "";

        if (Integer.valueOf(guess.getText().toString()) > randomNumber) {
            message = "Too high!";
        } else if (Integer.valueOf(guess.getText().toString()) < randomNumber) {
            message = "Too low!";
        } else {
            message = "You guessed it! The number is " + guess.getText().toString() + ". Try again!";
            generateRandomNumber();
        }

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
