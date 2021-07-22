package com.kata.romanconverter;

import com.kata.romanconverter.cli.PrintExceptionMessageHandler;
import com.kata.romanconverter.cli.ConverterCommand;
import picocli.CommandLine;

public class Application {

    public static void main(String[] args) {
        new CommandLine(new ConverterCommand())
                .setExecutionExceptionHandler(new PrintExceptionMessageHandler())
                .execute(args);
    }
}
