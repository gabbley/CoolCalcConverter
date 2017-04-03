package com.gabbley.coolcalcconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainScreen extends AppCompatActivity {

    //array list
    static ArrayList<String> stringList = new ArrayList<>();


    static int decNum;
    static int binNum;
    public static TextView display;
    public static String displayNum = "";
    public static Button one, two, three, four, five, six, seven, eight, nine, zero, clear;
    public static boolean binary, decimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        createObjects();
       display = (TextView) findViewById(R.id.txtNumbers);
    }

    public void mainConverter(View view){

        if ((display.length() < 0) || (display.getText().toString().equals(""))){
                display.setText("You need to enter a value");
        }
        else if ((view.getId() == R.id.btnDecimal) && (binary)){
            display.setText(binToDec(display.getText().toString()));
            decimal = true;
            binary = false;

        }
        else if ((view.getId() == R.id.btnBinary) && (decimal) ){
            display.setText(decToBin(display.getText().toString()));
            binary = true;
            decimal = false;
        }

    }

    public boolean overflowCheck(String s){
        if (Integer.parseInt(s) > 256)
            return true;
        else
            return false;

    }





    //identifies which number to display
    public void numButtonClicked(View view) {
        switch (view.getId()) {
            case R.id.btnOne : displayNum = ("1"); break;
            case R.id.btnTwo : displayNum =("2"); break;
            case R.id.btnThree : displayNum =("3"); break;
            case R.id.btnFour : displayNum =("4");break;
            case R.id.btnFive : displayNum =("5"); break;
            case R.id.btnSix : displayNum =("6"); break;
            case R.id.btnSeven : displayNum =("7"); break;
            case R.id.btnEight : displayNum =("8"); break;
            case R.id.btnNine : displayNum =("9");break;
            case R.id.btnZero : displayNum =("0"); break;
            default : displayNum = ("error");
        }

        displayNums();
    }

    //adds number onto current text
    public void displayNums(){
        String current = display.getText().toString();
        display.setText(current +displayNum);
    }

    //overrides setText method, String parameter instead of char[]
    public char[] setText(String s){
        char[] c = new char[s.length()];

        for (int i = 0; i<s.length(); i++){
            c[i] = s.charAt(i);
        }

        return c;

    }

    public void clearScreen(View view){
        display.setText("");
    }


    //creates buttons
    public void createObjects() {

        one = (Button) findViewById(R.id.btnOne);
        two = (Button) findViewById(R.id.btnTwo);
        three = (Button) findViewById(R.id.btnThree);
        four = (Button) findViewById(R.id.btnFour);
        five = (Button) findViewById(R.id.btnFive);
        six = (Button) findViewById(R.id.btnSix);
        seven = (Button) findViewById(R.id.btnSeven);
        eight = (Button) findViewById(R.id.btnEight);
        nine = (Button) findViewById(R.id.btnNine);
        zero = (Button) findViewById(R.id.btnZero);
        clear = (Button) findViewById(R.id.btnClear);

        decimal = true;

    }


    ///////////Decimal//Conversions/////////////////////////
    public String decToBin(String n){
        String num = "";
        if (overflowCheck(n)){
            display.setHint("The number is too large, please reenter a number");
        }
        else {

            decNum = Integer.parseInt(n);
            while (decNum != 0) {
                num = (decNum % 2) + num;
                decNum /= 2;
            }

            }
        return num;
    }


    //////////////////////////////////////////
    public String binToDec(String n){
        String num = "";
        if (overflowCheck(n)){
            display.setHint("The number is too large, please reenter a number");
        }
        else {

            decNum = 0;
            int i = 0;
            binNum = Integer.parseInt(n);

            while (true) {
                if (binNum == 0) {
                    break;
                } else {
                    int temp = binNum % 10;
                    decNum += temp * Math.pow(2, i);
                    binNum = binNum / 10;
                    i++;
                }
            }
        }
        num = String.valueOf(decNum);
        return num;
    }


}
