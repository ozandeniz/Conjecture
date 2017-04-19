package com.company;

/**
 * Created by ozandeniz on 19/04/2017.
 */
public class Util {

    public static double factorial(double value){
        if(value > 150){
            return value;
        }
        double result = 1;
        for (int i = 1; i <= value; i++) {
            result = result * i;
        }
        return result;
    }
}
