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
}