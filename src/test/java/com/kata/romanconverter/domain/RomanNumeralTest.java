package com.kata.romanconverter.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RomanNumeralTest {

    @ParameterizedTest
    @CsvSource({"1,I","5,V","10,X","50,L","100,C","500,D","1000,M"})
    void shouldConvertArabicNumberToSimpleRomanNumeral(int input, String expected) {
        assertThat(RomanNumeral.toRoman(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"2,II","8,VIII","16,XVI","33,XXXIII","42,XLII","75,LXXV","128,CXXVIII","650,DCL","2048,MMXLVIII"})
    void shouldConvertArabicNumberToCompoundRomanNumeral(int input, String expected) {
        assertThat(RomanNumeral.toRoman(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"4,IV","9,IX","40,XL","90,XC","400,CD","900,CM"})
    void shouldConvertArabicNumberToRomanNumeralRepresentedBySubtractiveNotation(int input, String expected) {
        assertThat(RomanNumeral.toRoman(input)).isEqualTo(expected);
    }

    @Test
    void shouldConvertArabicNumberToMaxRomanNumeralAllowed() {
        assertThat(RomanNumeral.toRoman(3999)).isEqualTo("MMMCMXCIX");
    }

    @ParameterizedTest
    @ValueSource(ints = {-1,0,4000})
    void shouldOnlyConvertArabicNumbersBetween1and3999ToRoman(int input) {
        assertThatThrownBy(() -> RomanNumeral.toRoman(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid number range. Please provide a value between 1 and 3999.");
    }

    @ParameterizedTest
    @CsvSource({"1,I","5,V","10,X","50,L","100,C","500,D","1000,M"})
    void shouldConvertSimpleRomanNumeralToArabicNumber(int expected, String input) {
        assertThat(RomanNumeral.toArabic(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"2,II","8,VIII","16,XVI","33,XXXIII","42,XLII","75,LXXV","128,CXXVIII","650,DCL","2048,MMXLVIII"})
    void shouldConvertCompoundRomanNumeralToArabicNumber(int expected, String input) {
        assertThat(RomanNumeral.toArabic(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"4,IV","9,IX","40,XL","90,XC","400,CD","900,CM"})
    void shouldConvertRomanNumeralRepresentedBySubtractiveNotationToArabicNumber(int expected, String input) {
        assertThat(RomanNumeral.toArabic(input)).isEqualTo(expected);
    }

    @Test
    void shouldConvertLowerCaseRomanToArabicNumber() {
        assertThat(RomanNumeral.toArabic("mmmdccxxiv")).isEqualTo(3724);
    }
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "\t", "\n"})
    void shouldNotAllowNullOrBlankInputWhenConvertingToArabic(String input) {
        assertThatThrownBy(() -> RomanNumeral.toArabic(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Please provide a Roman numeral to be converted.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"IL", "A", "II I"})
    void shouldNotAllowInvalidRomanNumeralsWhenConvertingToArabic(String input) {
        assertThatThrownBy(() -> RomanNumeral.toArabic(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The value " + input + " cannot be converted. Please provide a valid Roman numeral.");
    }

}