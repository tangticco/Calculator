package edu.fandm.ztang.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //create some variables for checking
    private boolean userIsTyping = false;

    private String displayText = "";

    /**
     * This is a method when a digit button beingh pressed
     * @param v : the button being pressed
     */
    public void touchDigit(View v){

        //get the text view to display the digits and result
        TextView displayView = (TextView)findViewById(R.id.displayView);

        //get the digit(String type) from the button
        int digitId = v.getId();    //get the id of the digit button
        Button digitButton  = (Button)findViewById(digitId);    //get the button by the id above
        String digitText = digitButton.getText().toString();


        //check if display TextView has something already on it/the user is typing
        if (userIsTyping){
            displayText = displayView.getText().toString() + digitText;
        }else{
            displayText = digitText;
        }

        //set the userIsTyping to true and display the text on the TextView
        userIsTyping = true;
        displayView.setText(displayText);

    }

}
