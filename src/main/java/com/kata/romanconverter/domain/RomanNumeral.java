package com.kata.romanconverter.domain;

import java.util.Objects;

public enum RomanNumeral {

    M(1000),
    CM(900),
    D(500),
    CD(400),
    C(100),
    XC(90),
    L(50),
    XL(40),
    X(10),
    IX(9),
    V(5),
    IV(4),
    I(1);

    private int arabicNumber;

    RomanNumeral(int arabicNumber) {
        this.arabicNumber = arabicNumber;
    }

    public int getArabicNumber() {
        return arabicNumber;
    }

    public static String toRoman(int number){
        validateNumberInput(number);
        StringBuilder result= new StringBuilder();

        for (var romanNumeral : RomanNumeral.values()) {
            while (number >= romanNumeral.getArabicNumber()){
                result.append(romanNumeral);
                number-=romanNumeral.getArabicNumber();
            }
        }
        return result.toString();
    }

    public static int toArabic(String roman){
        validateRomanNumeralInput(roman);
        String romanInput = roman.toUpperCase().trim();
        int result= 0;

        for (var romanNumeral : RomanNumeral.values()) {
            while(romanInput.startsWith(romanNumeral.name())){
                result+= romanNumeral.getArabicNumber();
                romanInput= romanInput.replaceFirst(romanNumeral.name(),"");
            }
        }
        return result;
    }

    private static void validateRomanNumeralInput(String roman) {
        if(Objects.isNull(roman) || roman.isBlank()){
            throw new IllegalArgumentException("Please provide a Roman numeral to be converted.");
        }
        if(!roman.matches("(?i)^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$")){
            throw new IllegalArgumentException("The value " + roman + " cannot be converted. Please provide a valid Roman numeral.");
        }
    }

    private static void validateNumberInput(int number) {
        if(number < 1 || number > 3999){
            throw new IllegalArgumentException("Invalid number range. Please provide a value between 1 and 3999.");
        }
    }
}
