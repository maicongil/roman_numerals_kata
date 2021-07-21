import java.util.Map;

public class RomanNumeral {

    private static final Map<String, Integer> romanToArabicMap =
            Map.of(
                    "I", 1,
                    "V", 5,
                    "X", 10,
                    "L", 50,
                    "C", 100,
                    "D", 500,
                    "M", 1000
            );

    public static String toRoman(int arabicNumber){
        String result= null;

        for (var romanToArabicEntry : romanToArabicMap.entrySet()) {
            if(arabicNumber == romanToArabicEntry.getValue()){
                result = romanToArabicEntry.getKey();
            }
        }
        return result;
    }
}
