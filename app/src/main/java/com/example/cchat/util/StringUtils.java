package com.example.cchat.util;

public class StringUtils {

    public static boolean isEmpty(String str){

        if(str == null ||str.length() <= 0) return true;
        else return false;
    }
}
