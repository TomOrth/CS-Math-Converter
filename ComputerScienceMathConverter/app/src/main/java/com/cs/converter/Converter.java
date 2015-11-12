package com.cs.converter;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by tom on 10/24/15.
 */
public class Converter {

    public static String hexToDec(String val){
        //Convert

        int finalAnswer = 0;
        char tempData[] = val.toCharArray();
        //Final conversion step
        for(int y = 0; y < tempData.length; ++y) {
            switch (tempData[y]) {
                case 'A':
                    finalAnswer += 10 * Math.pow(16, (tempData.length - 1) - y);
                    break;
                case 'B':
                    finalAnswer += 11 * Math.pow(16, (tempData.length - 1) - y);
                    break;
                case 'C':
                    finalAnswer += 12 * Math.pow(16, (tempData.length - 1) - y);
                    break;
                case 'D':
                    finalAnswer += 13 * Math.pow(16, (tempData.length - 1) - y);
                    break;
                case 'E':
                    finalAnswer += 14 * Math.pow(16, (tempData.length - 1) - y);
                    break;
                case 'F':
                    finalAnswer += 15 * Math.pow(16, (tempData.length - 1) - y);
                    break;
               default:
                    finalAnswer += Character.getNumericValue(tempData[y]) * Math.pow(16, (tempData.length - 1) - y);
                    break;
            }
        }
        return String.valueOf(finalAnswer);
    }
    public static String octToDec(String value){
        int finalAnswer = 0;
        char tempData[] = value.toCharArray();
        Log.d("dataRec", value);
        String ret  = "";
        boolean isValid = true;
        for(int x = 0; x < tempData.length; ++x) {
            if (tempData[x] == '8') {
                isValid = false;
                break;
            }
            else {
                finalAnswer += Character.getNumericValue(tempData[x]) * Math.pow(8, (tempData.length - 1) - x);
            }

        }
        if(!isValid){
            ret = "Octal input invalid";
            Log.d("return", ret);
        }
        else{
            ret = "Final Value is: " + String.valueOf(finalAnswer);
            Log.d("return", ret);
        }
        return ret;
    }
    public static String binToDec(String value){
        int finalAnswer = 0;
        char tempData[] = value.toCharArray();
        Log.d("dataRec", value);
        String ret  = "";
        boolean isValid = true;
        for(int x = 0; x < tempData.length; ++x) {
            if (Character.getNumericValue(tempData[x]) > 1) {
                isValid = false;
                break;
            }
            else {
                finalAnswer += Character.getNumericValue(tempData[x]) * Math.pow(2, (tempData.length - 1) - x);
            }

        }
        if(!isValid){
            ret = "Binary input invalid";
            Log.d("return", ret);
        }
        else{
            ret = "Final Value is: " + String.valueOf(finalAnswer);
            Log.d("return", ret);
        }
        return ret;
    }
    public static String decToBin(String value){
        String finalAns = "", START = "Final Value is: ";
        int iValue = Integer.parseInt(value);
        boolean isGrow = true;
        int power = 1;
        while(isGrow){
            if(iValue/Math.pow(2, power) < 2 && iValue/Math.pow(2, power) >= 1) {
                iValue -= Math.pow(2, power);
                Log.d("Power", String.valueOf(power));
                Log.d("iValue", String.valueOf(iValue));
                finalAns += "1";
                isGrow = false;
            }
            else{
                power++;
            }
        }
        for(int b = power - 1; b >= 0; --b){
            if(iValue/Math.pow(2, b) < 2 && iValue/Math.pow(2, b) >= 1){
                iValue -= Math.pow(2, b);
                finalAns += "1";
            }
            else if(iValue/Math.pow(2, b) < 1){
                finalAns += "0";
            }
            else if(iValue == 0){
                break;
            }
        }
        return START + finalAns;
    }
    public static String decToOct(String value) {
        String finalAns = "", START = "Final Value is: ";
        int dValue = Integer.parseInt(value);
        int start = 0;
        boolean isPower = true;
        int power = 1;
        while (isPower) {
            if (dValue / Math.pow(8, power) >= 1) {
                power++;
            } else if (dValue / Math.pow(8, power) < 1) {
                isPower = false;
            }

        }
        for (int i = power; i > 0; --i) {
            finalAns += String.valueOf(((int)((dValue) / Math.pow(8, i))));
            dValue -= ((int)(dValue / Math.pow(8, i))) * Math.pow(8, i);

        }
        finalAns += String.valueOf(dValue);
        int temp = Integer.parseInt(finalAns);
        finalAns = String.valueOf(temp);
        return START + finalAns;
    }
    public static String decToHex(String value) {
        String finalAns = "", START = "Final Value is: ";
        int dValue = Integer.parseInt(value);
        int start = 0;
        boolean isPower = true;
        int power = 1;
        while (isPower) {
            if (dValue / Math.pow(16, power) >= 1) {
                power++;
            } else if (dValue / Math.pow(16, power) < 1) {
                isPower = false;
            }

        }
        for (int i = power; i > 0; --i) {
            finalAns += String.valueOf(((int)((dValue) / Math.pow(16, i))));
            dValue -= ((int)(dValue / Math.pow(16, i))) * Math.pow(16, i);

        }
        finalAns += String.valueOf(dValue);
        int temp = Integer.parseInt(finalAns);
        finalAns = String.valueOf(temp);
        finalAns = finalAns.replaceAll("10", "A");
        finalAns = finalAns.replaceAll("11", "B");
        finalAns = finalAns.replaceAll("12", "C");
        finalAns = finalAns.replaceAll("13", "D");
        finalAns = finalAns.replaceAll("14", "E");
        finalAns = finalAns.replaceAll("15", "F");
        return START + finalAns;
    }

}
