package com.google.utils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {

    public static String extractUrl(String inputString){
        return inputString.split("\\s+")[0];
    }
}

