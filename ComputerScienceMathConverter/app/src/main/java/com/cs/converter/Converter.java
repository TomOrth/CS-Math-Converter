package com.cs.converter;

import java.util.Arrays;

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
        String ret  = "";
        boolean isValid = true;
        for(int x = 0; x < tempData.length; ++x) {
            StringBuilder build = new StringBuilder(tempData[x]);
            if (build.toString().contains("8")) {
                isValid = false;
                break;
            }
            else {
                finalAnswer += Integer.parseInt(build.toString()) * Math.pow(16, (tempData.length - 1) - x);
            }

        }
        if(!isValid){
            ret = "Octal input invalid";
        }
        else{
            ret = "Final Answer is: " + String.valueOf(ret);
        }
        return ret;
    }

}
