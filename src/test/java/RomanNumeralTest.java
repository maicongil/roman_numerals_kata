import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RomanNumeralTest {

    @Test
    void shouldConvert1ToRoman() {
        assertThat(RomanNumeral.toRoman(1)).isEqualTo("I");
    }

    @Test
    void shouldConvert5ToRoman() {
        assertThat(RomanNumeral.toRoman(5)).isEqualTo("V");
    }

    @Test
    void shouldConvert10ToRoman() {
        assertThat(RomanNumeral.toRoman(10)).isEqualTo("X");
    }

    @Test
    void shouldConvert50ToRoman() {
        assertThat(RomanNumeral.toRoman(50)).isEqualTo("L");
    }

    @Test
    void shouldConvert100ToRoman() {
        assertThat(RomanNumeral.toRoman(100)).isEqualTo("C");
    }

    @Test
    void shouldConvert500ToRoman() {
        assertThat(RomanNumeral.toRoman(500)).isEqualTo("D");
    }

    @Test
    void shouldConvert1000ToRoman() {
        assertThat(RomanNumeral.toRoman(1000)).isEqualTo("M");
    }

    @Test
    void shouldConvert3ToRoman() {
        assertThat(RomanNumeral.toRoman(3)).isEqualTo("III");
    }

    @Test
    void shouldConvert7ToRoman() {
        assertThat(RomanNumeral.toRoman(7)).isEqualTo("VII");
    }

    @Test
    void shouldConvert13ToRoman() {
        assertThat(RomanNumeral.toRoman(13)).isEqualTo("XIII");
    }

    @Test
    void shouldConvert35ToRoman() {
        assertThat(RomanNumeral.toRoman(35)).isEqualTo("XXXV");
    }

    @Test
    void shouldConvert4ToRoman() {
        assertThat(RomanNumeral.toRoman(4)).isEqualTo("IV");
    }

    @Test
    void shouldConvert9ToRoman() {
        assertThat(RomanNumeral.toRoman(9)).isEqualTo("IX");
    }

    @Test
    void shouldConvert40ToRoman() {
        assertThat(RomanNumeral.toRoman(40)).isEqualTo("XL");
    }

    @Test
    void shouldConvert90ToRoman() {
        assertThat(RomanNumeral.toRoman(90)).isEqualTo("XC");
    }

    @Test
    void shouldConvert400ToRoman() {
        assertThat(RomanNumeral.toRoman(400)).isEqualTo("CD");
    }

    @Test
    void shouldConvert900ToRoman() {
        assertThat(RomanNumeral.toRoman(900)).isEqualTo("CM");
    }

    @ParameterizedTest
    @ValueSource(ints = {-1,0,4000})
    void shouldOnlyConvertNumbersBetween1and3999ToRoman(int input) {
        assertThatThrownBy(() -> RomanNumeral.toRoman(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid number range. Please provide a value between 1 and 3999.");
    }

    @Test
    void shouldConvertIToArabic() {
        assertThat(RomanNumeral.toArabic("I")).isEqualTo(1);
    }

    @Test
    void shouldConvertIVToArabic() {
        assertThat(RomanNumeral.toArabic("IV")).isEqualTo(4);
    }

    @Test
    void shouldConvertVToArabic() {
        assertThat(RomanNumeral.toArabic("V")).isEqualTo(5);
    }

    @Test
    void shouldConvertIXToArabic() {
        assertThat(RomanNumeral.toArabic("IX")).isEqualTo(9);
    }

    @Test
    void shouldConvertXToArabic() {
        assertThat(RomanNumeral.toArabic("X")).isEqualTo(10);
    }

    @Test
    void shouldConvertXLToArabic() {
        assertThat(RomanNumeral.toArabic("XL")).isEqualTo(40);
    }

    @Test
    void shouldConvertLToArabic() {
        assertThat(RomanNumeral.toArabic("L")).isEqualTo(50);
    }

    @Test
    void shouldConvertXCToArabic() {
        assertThat(RomanNumeral.toArabic("XC")).isEqualTo(90);
    }

    @Test
    void shouldConvertCToArabic() {
        assertThat(RomanNumeral.toArabic("C")).isEqualTo(100);
    }

    @Test
    void shouldConvertCDToArabic() {
        assertThat(RomanNumeral.toArabic("CD")).isEqualTo(400);
    }

    @Test
    void shouldConvertDToArabic() {
        assertThat(RomanNumeral.toArabic("D")).isEqualTo(500);
    }

    @Test
    void shouldConvertCMToArabic() {
        assertThat(RomanNumeral.toArabic("CM")).isEqualTo(900);
    }

    @Test
    void shouldConvertMToArabic() {
        assertThat(RomanNumeral.toArabic("M")).isEqualTo(1000);
    }

    @Test
    void shouldConvertIIIToArabic() {
        assertThat(RomanNumeral.toArabic("III")).isEqualTo(3);
    }

    @Test
    void shouldConvertXIIToArabic() {
        assertThat(RomanNumeral.toArabic("XII")).isEqualTo(12);
    }

    @Test
    void shouldConvertLXIVToArabic() {
        assertThat(RomanNumeral.toArabic("LXIV")).isEqualTo(64);
    }


}