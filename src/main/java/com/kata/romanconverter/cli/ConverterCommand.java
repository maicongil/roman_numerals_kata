package com.kata.romanconverter.cli;

import com.kata.romanconverter.domain.RomanNumeral;
import picocli.CommandLine.HelpCommand;
import picocli.CommandLine.Parameters;

import static picocli.CommandLine.Command;

@Command(name="convert", subcommands = {HelpCommand.class})
public class ConverterCommand {

    @Command(name = "toRoman", description = "Converts a number to a Roman numeral")
    void toRoman(@Parameters(arity = "1", paramLabel = "<number>", description = "A positive integer between 1 and 3999") int number){
        System.out.println(RomanNumeral.toRoman(number));
    }

    @Command(name = "toArabic", description = "Converts a Roman numeral to an Arabic number")
    void toArabic(@Parameters(arity = "1", paramLabel = "<roman_numeral>", description = "A valid Roman numeral between I and MMMCMXCIX") String romanNumeral){
        System.out.println(RomanNumeral.toArabic(romanNumeral));
    }
}
