package edu.fandm.ztang.calculator;

import java.util.Map;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;


/**
 * A class that implement the model of calculator
 */
public class CalculatorModel {

    //set up some class-wide variables for use
    private double accumulator = 0.0;   //the current accumulator
    private boolean isPending = false;  //to check if it is the second part of binary operation(whether the first operand has been set or not)
    private double firstOperand = 0.0;  //to store the first operand for a binary operation
    private double result = 0.0;    //to store the result of the operations
    private String operationSymbol = "";  //store the last operation


    /**
     *set the currentOperand to accumulator for future use
     */
    public void setOperand(double currentOperand){
        accumulator = currentOperand;
    }

    /**
     * perform the operations
     * @param currentOperation
     */
    public void performOperation(String currentOperation){


        //check if it is the first part of the operation. That is, if the isPending is false, then store the currentOperand to the first operand variable


        if(!isPending){
            operationSymbol = currentOperation;
            firstOperand = accumulator;
            isPending = true;
        }
        //if it is the second part of the operation, then culculate the result
        else{

            if(currentOperation.equals("=")){
                performOperationHelper();
                firstOperand = result;
                isPending = false;  //after enter the equal sign, set the isPending to true and store the previous result to the first Operand
            }else{
                operationSymbol = currentOperation;
                performOperationHelper();
            }
        }


    }

    /**
     * get method for result
     * @return the result of operations
     */
    public double getResult(){
        return result;
    }

    private void performOperationHelper(){
        switch (operationSymbol){
            case "+":
                result = firstOperand + accumulator;

            case "-":
                result = firstOperand - accumulator;
            case "*":
                result = firstOperand * accumulator;
            case "/":
                result = firstOperand / accumulator;
        }

        System.out.print(result);
    }

    public void clear(){

        accumulator = 0.0;
        isPending = false;
        firstOperand = 0.0;
        result = 0.0;
        operationSymbol = "";

    }







}
