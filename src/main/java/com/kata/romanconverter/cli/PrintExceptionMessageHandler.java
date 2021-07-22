package com.kata.romanconverter.cli;

import picocli.CommandLine;
import picocli.CommandLine.IExecutionExceptionHandler;

public class PrintExceptionMessageHandler implements IExecutionExceptionHandler {
    public int handleExecutionException(Exception ex,
                                        CommandLine cmd,
                                        CommandLine.ParseResult parseResult) {

        cmd.getErr().println(cmd.getColorScheme().errorText(ex.getMessage()));

        return cmd.getExitCodeExceptionMapper() != null
                ? cmd.getExitCodeExceptionMapper().getExitCode(ex)
                : cmd.getCommandSpec().exitCodeOnExecutionException();
    }
}