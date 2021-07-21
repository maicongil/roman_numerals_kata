import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RomanNumeralTest {

    @Test
    void shouldConvert1ToRoman(){
        assertThat(RomanNumeral.toRoman(1)).isEqualTo("I");
    }

}