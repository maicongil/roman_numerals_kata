package com.kata.romanconverter.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class RomanNumeral {

    private static final Map<String, Integer> romanToArabicMap;

    static{
        romanToArabicMap = new LinkedHashMap<>();
        romanToArabicMap.put("M", 1000);
        romanToArabicMap.put("CM", 900);
        romanToArabicMap.put("D", 500);
        romanToArabicMap.put("CD", 400);
        romanToArabicMap.put("C", 100);
        romanToArabicMap.put("XC", 90);
        romanToArabicMap.put("L", 50);
        romanToArabicMap.put("XL", 40);
        romanToArabicMap.put("X", 10);
        romanToArabicMap.put("IX", 9);
        romanToArabicMap.put("V", 5);
        romanToArabicMap.put("IV", 4);
        romanToArabicMap.put("I", 1);
    }

    public static String toRoman(int number){
        validateArabicNumberInput(number);
        StringBuilder result= new StringBuilder();

        for (var romanToArabicEntry : romanToArabicMap.entrySet()) {
            while (number >= romanToArabicEntry.getValue()){
                result.append(romanToArabicEntry.getKey());
                number-=romanToArabicEntry.getValue();
            }
        }
        return result.toString();
    }

    public static int toArabic(String roman){
        validateRomanNumeralInput(roman);
        String romanNumeral = roman.toUpperCase().trim();
        int result= 0;

        for (var romanToArabicEntry : romanToArabicMap.entrySet()) {
            while(romanNumeral.startsWith(romanToArabicEntry.getKey())){
                result+= romanToArabicEntry.getValue();
                romanNumeral= romanNumeral.replaceFirst(romanToArabicEntry.getKey(),"");
            }
        }

        if(!romanNumeral.isEmpty()){
            throw new IllegalArgumentException("The value " +roman+ " cannot be converted. Please provide a valid Roman numeral.");
        }

        return result;
    }

    private static void validateRomanNumeralInput(String roman) {
        if(Objects.isNull(roman) || roman.isBlank()){
            throw new IllegalArgumentException("Please provide a Roman numeral to be converted.");
        }
    }

    private static void validateArabicNumberInput(int number) {
        if(number < 1 || number > 3999){
            throw new IllegalArgumentException("Invalid number range. Please provide a value between 1 and 3999.");
        }
    }
}
