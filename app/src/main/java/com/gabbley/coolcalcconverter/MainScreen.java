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
    static int rem;
    static String newNumber = "";
    static String returnedNum = "";
    static String addedNumber = "";
    static int check = 0;
    public static TextView display;
    public static String displayNum = "";
    public static RadioButton dec, bin;
    public static Button one, two, three, four, five, six, seven, eight, nine, zero, clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        //createObjects();
       display = (TextView) findViewById(R.id.txtNumbers);
    }

    public void mainConverter(View view){
        String fromScreen = "";
        String converted = "";

        if (bin.isChecked()){
            fromScreen = display.getText().toString();

            display.setText(converted);
        }

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
    public void creatObjects() {

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
        dec = (RadioButton) findViewById(R.id.rbnDec);
        bin = (RadioButton) findViewById(R.id.rbnBinary);
    }


    ///////////Decimal//Conversions/////////////////////////
    static public String decToBin(String n){
        String num = "";
        decNum = Integer.parseInt(n);
        while(decNum!=0){
            num = (decNum%2) + num;
            decNum/=2;
        }
        return num;
    }


    //////////////////////////////////////////
    static public String binToDec(String n){
        String num = "";
        decNum=0;
        int i = 0;
        binNum = Integer.parseInt(n);

        while(true){
            if(binNum == 0){
                break;
            }
            else {
                int temp = binNum%10;
                decNum += temp*Math.pow(2, i);
                binNum = binNum/10;
                i++;
            }
        }
        num = String.valueOf(decNum);
        return num;
    }


}
