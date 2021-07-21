import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumeral {

    private static final Map<String, Integer> romanToArabicMap;

    static{
        romanToArabicMap = new LinkedHashMap<>();
        romanToArabicMap.put("M", 1000);
        romanToArabicMap.put("D", 500);
        romanToArabicMap.put("C", 100);
        romanToArabicMap.put("L", 50);
        romanToArabicMap.put("X", 10);
        romanToArabicMap.put("V", 5);
        romanToArabicMap.put("I", 1);
    }

    public static String toRoman(int arabicNumber){
        StringBuilder result= new StringBuilder();

        for (var romanToArabicEntry : romanToArabicMap.entrySet()) {
            while (arabicNumber >= romanToArabicEntry.getValue()){
                result.append(romanToArabicEntry.getKey());
                arabicNumber-=romanToArabicEntry.getValue();
            }
        }
        return result.toString();
    }
}
