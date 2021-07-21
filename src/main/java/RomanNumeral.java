import java.util.LinkedHashMap;
import java.util.Map;

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

    public static String toRoman(int arabicNumber){
        validateArabicNumberInput(arabicNumber);
        StringBuilder result= new StringBuilder();

        for (var romanToArabicEntry : romanToArabicMap.entrySet()) {
            while (arabicNumber >= romanToArabicEntry.getValue()){
                result.append(romanToArabicEntry.getKey());
                arabicNumber-=romanToArabicEntry.getValue();
            }
        }
        return result.toString();
    }

    public static int toArabic(String romanNumeral){
        int result= 0;

        for (var romanToArabicEntry : romanToArabicMap.entrySet()) {
            if(romanNumeral == romanToArabicEntry.getKey()){
                result= romanToArabicEntry.getValue();
            }
        }
        return result;
    }

    private static void validateArabicNumberInput(int arabicNumber) {
        if(arabicNumber < 1 || arabicNumber > 3999){
            throw new IllegalArgumentException("Invalid number range. Please provide a value between 1 and 3999.");
        }
    }
}
