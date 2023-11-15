package org.example.parser;

import org.example.parserTask.exceptions.CommandLineParserException;
import org.example.parserTask.parser.CommandLineParser;
import org.example.parserTask.setting.Setting;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CommandLineParserTest {
    CommandLineParser commandLineParser = new CommandLineParser();
    private static List<String> list = new ArrayList<>();


    private static Stream<Arguments> getParserException() {
        return Stream.of(
                Arguments.of(new String[0], "No parameters"),
                Arguments.of(new String[]{"t", "-s"}, "Not enough parameters "),
                Arguments.of(new String[]{"t", "s", "t1"}, "Keys have mistake")
        );
    }

    @ParameterizedTest
    @MethodSource("getParserException")
    void parserException(String[] str,
                         String message) {
        Exception e = assertThrows(CommandLineParserException.class, () -> CommandLineParser.parser(str));
        assertEquals(message, e.getMessage());
    }

    @Test
    void parserTest() throws CommandLineParserException {
        String[] str = new String[]{"t", "-s", "t2", "t1"};
        list.add("t1");
        list.add("t2");
        Setting actualSet = CommandLineParser.parser(str);

        assertEquals(str[0], actualSet.getFileName());
        assertEquals("-a", actualSet.getSortMode());
        assertEquals(str[1], actualSet.getDateType());
        assertEquals(list, actualSet.getListNextFile());
    }

    @Test
    void isDateTypeCorrectExcept() throws CommandLineParserException {
        Exception e = assertThrows(CommandLineParserException.class, () -> CommandLineParser.isDateTypeCorrect("-a"));
        assertEquals("The key for dateType is not correct", e.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"-s", "-i"})
    void isDateTypeCorrect(String str) throws CommandLineParserException {
        assertEquals(true, commandLineParser.isDateTypeCorrect(str));
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "-s"})
    void isFileNameNotEmptyException(String str) throws CommandLineParserException {
        assertThrows(CommandLineParserException.class, () -> commandLineParser.isFileNameNotEmpty(str));
    }

    @Test
    void isFileNameNotEmpty() throws CommandLineParserException {
        assertEquals(true, commandLineParser.isFileNameNotEmpty("test"));
    }

    @Test
    void hasListNextFileDateException() throws CommandLineParserException {
        List<String> list1 = new ArrayList<>();
        assertThrows(CommandLineParserException.class, () -> commandLineParser.hasListNextFileDate(list1));
    }

    @Test
    void hasListNextFileDate() throws CommandLineParserException {
        list.add("t1");
        assertEquals(true, commandLineParser.hasListNextFileDate(list));
    }
}