package com.know.java.numbers_strings.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

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

    @Test
    void parseFromString() {
        // assert is primitive type after parsing
        String numString = "2025";
        int intValue = sut.parseIntFromString(numString);
        float fValue = sut.parseFloatFromString(numString);
        assertEquals(2025, intValue);
        assertEquals(2025f, fValue);

        // assert a Float object
        assertInstanceOf(Float.class, Float.valueOf(numString));
    }

    @Test
    void numberToString() {
        int v = 34;
        float f = 35f;
        double d = 68.3;

        String result = sut.numberToString(v);
        assertInstanceOf(String.class, result);
        assertEquals("34", result);

        result = sut.numberToString(f);
        assertInstanceOf(String.class, result);
        assertEquals("35.0", result);

        result = sut.numberToString(d);
        assertInstanceOf(String.class, result);
        assertEquals("68.3", result);
    }

    @Test
    void getCharAtFromString() {
        String s = "Java Developer";
        int index = 2;
        char result = sut.getCharAtFromString(s, index);
        assertEquals('v', result);
        assertInstanceOf(Character.class, result);
    }

    @Test
    void substringFromString() {
        String aPalindrome = "Niagara. O roar again!";
        String result = sut.substringFromString(aPalindrome, aPalindrome.length() - 1);
        assertEquals("!", result);

        int dotIndex = aPalindrome.indexOf(".");
        result = sut.subStringFromToIndex(aPalindrome, 0, dotIndex);
        assertEquals("Niagara", result);
    }

    @Test
    void searchRegularExpression() {
        String myStr = "This i4s a1 mix di1g7t, and n3on dig4it 9sequences";
        String regex = "[\\s\\d,.]+";
        String[] myArray = myStr.split(regex);
        System.out.println(Arrays.toString(myArray));
    }

    @Test
    void subSequenceTest() {
        CharSequence s = new StringBuilder("Java Developer");
        CharSequence charSequence = s.subSequence(5, 12);
        assertEquals("Develop", charSequence);
    }

    @Test
    void trimFromStringTest() {
        String s = "   Java Developer   ";
        String result = s.trim();
        assertEquals("Java Developer", result);
    }

    @Test
    void upperCaseStringTest() {
        String s = "Java Developer";
        String result = s.toUpperCase();
        assertEquals("JAVA DEVELOPER", result);
    }
}