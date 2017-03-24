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
    static int octalNum;
    static int hexNum;
    static int rem;
    static String newNumber = "";
    static String returnedNum = "";
    static String addedNumber = "";
    static int check = 0;
    static String hexNumber1 = "";
    public static TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        //createObjects();
       display = (TextView) findViewById(R.id.txtNumbers);
    }

    //identifies which number to display
    public String numButtonClicked(View view) {
        switch (view.getId()) {
            case R.id.btnOne : return "1";
            case R.id.btnTwo : return "2";
            case R.id.btnThree : return "3";
            case R.id.btnFour : return "4";
            case R.id.btnFive : return "5";
            case R.id.btnSix : return "6";
            case R.id.btnSeven : return "7";
            case R.id.btnEight : return "8";
            case R.id.btnNine : return "9";
            case R.id.btnZero : return "0";
            default : return "err";
        }
    }

    //overrides setText method, String parameter instead of char[]
    public char[] setText(String s){
        char[] c = new char[s.length()];

        for (int i = 0; i<s.length(); i++){
            c[i] = s.charAt(i);
        }

        return c;

    }


    //creates buttons
    public void creatObjects(){

        Button one = (Button) findViewById(R.id.btnOne);
        Button two = (Button) findViewById(R.id.btnTwo);
        Button three = (Button) findViewById(R.id.btnThree);
        Button four = (Button) findViewById(R.id.btnFour);
        Button five = (Button) findViewById(R.id.btnFive);
        Button six = (Button) findViewById(R.id.btnSix);
        Button seven = (Button) findViewById(R.id.btnSeven);
        Button eight = (Button) findViewById(R.id.btnEight);
        Button nine = (Button) findViewById(R.id.btnNine);
        Button zero = (Button) findViewById(R.id.btnZero);
        Button reset = (Button) findViewById(R.id.btnClear);
     //   RadioButton dec (Rad)
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
    static public String decToOctal(String n){
        String num = "";
        decNum = Integer.parseInt(n);

        char dig[]={'0','1','2','3','4','5','6','7'};

        while(decNum!=0){
            rem=decNum%8;
            num=dig[rem]+num;
            decNum=decNum/8;
        }
        return num;
    }
    //////////////////////////////////////////
    static public String decToHex(String n){
        String num = "";
        decNum = Integer.parseInt(n);

        char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(decNum!=0)
        {
            rem=decNum%16;
            num=hex[rem]+num;
            decNum=decNum/16;
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

    static public String binToOctal(String n){
        String num = "";
        String temp = "";
        temp = binToDec(n);
        num = decToOctal(temp);
        return num;
    }
    static public String binToHex(String n){
        String num = "";
        String temp = "";
        temp = binToDec(n);
        num = decToHex(temp);
        return num;
    }

    static public String octalToDec(String n){
        String num = "";
        decNum=0;
        int i = 0;
        octalNum = Integer.parseInt(n);

        while(true){
            if(octalNum == 0){
                break;
            }
            else {
                decNum = decNum + (octalNum%10) * (int) Math.pow(8, i);
                i++;
                octalNum = octalNum/10;
            }
        }
        num = String.valueOf(decNum);
        return num;
    }
    static public String octalToBin(String n){

        String num = "";
        String temp = "";
        temp = octalToDec(n);
        num = decToBin(temp);
        return num;
    }
    static public String octalToHex(String n){

        String num = "";
        String temp = "";
        temp = octalToDec(n);
        num = decToHex(temp);
        return num;
    }

    /////////////////////////////Hex/////////////Conversions///////////////////////////////////////

    static public String hexToBin(String n){
        String bin = "";
        String binFragment = "";
        String hex = "";
        String x= n;
        for(int i = 0; i < n.length(); i++){

            hex = x.substring(i,i+1);
            switch (hex) {
                case "0":binFragment = "0000";
                    break;
                case "1": binFragment = "0001";
                    break;
                case "2":binFragment = "0010";
                    break;
                case "3":binFragment = "0011";
                    break;
                case "4":binFragment = "0100";
                    break;
                case "5":binFragment = "0101";
                    break;
                case "6":binFragment = "0110";
                    break;
                case "7":binFragment = "0111";
                    break;
                case "8":binFragment = "1000";
                    break;
                case "9":binFragment = "1001";
                    break;
                case "A":binFragment = "1010";
                    break;
                case "B":binFragment = "1011";
                    break;
                case "C":binFragment = "1100";
                    break;
                case "D":binFragment = "1101";
                    break;
                case "E":binFragment = "1110";
                    break;
                case "F":binFragment = "1111";
                    break;
                default:binFragment = "";
            }
            bin += binFragment;
        }
        return bin;
    }
/*    ///////////////////////////////////////
    static public String hexToDec(String n){
        String temp = "";
        String num = "";
        temp = finalProject.hexToBin(n);
        num = finalProject.binToDec(temp);
        return num;
    }
    ///////////////////////////////////////////
    static public String hexToOctal(String n){
        String temp = "";
        String num = "";
        temp = finalProject.hexToBin(n);
        num = finalProject.binToOctal(temp);
        return num;
    }*/



}
