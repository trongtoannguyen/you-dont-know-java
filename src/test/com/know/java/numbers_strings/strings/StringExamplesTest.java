package com.know.java.numbers_strings.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StringExamplesTest {

    @Mock
    StringExamples sut;

    @BeforeEach
    void setUp() {
        sut = new StringExamples();
    }

    @Test
    void createStrings() {
        // create a string object with string literal
        String helloLiteral = "hello world!";
        assertEquals("hello world!", helloLiteral);

        // create with constructor
        char[] helloChars = {'H', 'e', 'l', 'l', 'o', '!'};
        String hello = new String(helloChars);
        assertEquals("Hello!", hello);
    }

    @Test
    void getStringLength() {
        int expected = 5;
        char[] chars = new char[expected];
        for (char i = 0; i < expected; i++) {
            chars[i] = i;
        }
        int result = sut.getStringLength(new String(chars));
        assertEquals(expected, result);
    }

    @Test
    void reverseString() {
        String string = "Tod saw I was Dot";
        String expected = "toD saw I was doT";
        String result = sut.reverseString(string);
        assertEquals(expected, result);
    }

    @Test
    void concatStrings() {
        // compare string created from the + operator with concat method
        String firstName = "Java";
        String lastName = "Developer";
        String expected = firstName + lastName;
        String result = sut.concatStrings(firstName, lastName);
        assertEquals(expected, result);

        // concat mixing types
        int age = 18;
        String mixString = "I am " + age + "yo";
        assertInstanceOf(String.class, mixString);
    }

    @Test
    void createFormatString() {
        String fs = sut.createFormatString(7f, 5, "Java");
        System.out.println(fs);
    }
}