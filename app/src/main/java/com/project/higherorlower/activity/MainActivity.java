package com.project.higherorlower.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.project.higherorlower.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNumber;
    public void generateRandomNumber(){
        Random rand = new Random();
        randomNumber = rand.nextInt(20)+1;
    }

    public void guessIt(View view){

        EditText editText = (EditText) findViewById(R.id.et_input);
        int guessText = Integer.parseInt(editText.getText().toString());
        String message = null;

        if(guessText > randomNumber){
            message = "Lower!";
        }
        else if(guessText < randomNumber){
            message = "Higher!";
        }
        else {
                message = "You got it!! Try Again";
                generateRandomNumber();
            }


        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();

        Log.i("number passed",Integer.toString(randomNumber));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       generateRandomNumber();

    }
}
