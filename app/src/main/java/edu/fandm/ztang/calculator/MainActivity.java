package edu.fandm.ztang.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //create some variables for checking
    private boolean userIsTyping = false;
    private String displayText = "";
    private CalculatorModel newCalcModel = new CalculatorModel();

    /**
     * This is a method when a digit button being pressed
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
        displayToView();

    }

    /**
     * this is a method when a operation button being pressed
     * @param v: the button being pressed
     */
    public void touchOperation(View v){



        //get the digit(String type) from the button
        int operationId = v.getId();    //get the id of the digit button
        Button operationButton  = (Button)findViewById(operationId);    //get the button by the id above
        String operationText = operationButton.getText().toString();

        if(userIsTyping){
            newCalcModel.setOperand(Double.parseDouble(displayText));
            userIsTyping = false;
        }

        newCalcModel.performOperation(operationText);

        if(operationText.equals("=")){
            double result = newCalcModel.getResult();
            displayText =  Double.toString(result);
            displayToView();
        }else{
            //display the operation to the displayView
            displayText = operationText;
            displayToView();
        }

    }


    /**
     * display the text to the text view
     */
    public void displayToView(){
        //get the text view to display the digits and result
        TextView displayView = (TextView)findViewById(R.id.displayView);
        displayView.setText(displayText);
    }

}
