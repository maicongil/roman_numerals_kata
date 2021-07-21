import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RomanNumeralTest {

    @Test
    void shouldConvert1ToRoman(){
        assertThat(RomanNumeral.toRoman(1)).isEqualTo("I");
    }

    @Test
    void shouldConvert5ToRoman(){
        assertThat(RomanNumeral.toRoman(5)).isEqualTo("V");
    }

    @Test
    void shouldConvert10ToRoman(){
        assertThat(RomanNumeral.toRoman(10)).isEqualTo("X");
    }

    @Test
    void shouldConvert50ToRoman(){
        assertThat(RomanNumeral.toRoman(50)).isEqualTo("L");
    }

    @Test
    void shouldConvert100ToRoman(){
        assertThat(RomanNumeral.toRoman(100)).isEqualTo("C");
    }

    @Test
    void shouldConvert500ToRoman(){
        assertThat(RomanNumeral.toRoman(500)).isEqualTo("D");
    }

    @Test
    void shouldConvert1000ToRoman(){
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
}