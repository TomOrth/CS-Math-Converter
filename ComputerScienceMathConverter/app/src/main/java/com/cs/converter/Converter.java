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

}
