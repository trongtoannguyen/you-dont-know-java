package com.know.java.numbers_strings.strings;

public class StringExamples {

    public void createStrings() {
        // the most direct way to create a string is string literal:
        String greeting = "Hello world!"; // in this case, the compiler creates a string object with a value "Hello world!"
        System.out.println(greeting);

        // create another string with constructor
        char[] helloChars = {'H', 'e', 'l', 'l', 'o', '!'};
        String hello = new String(helloChars);
        System.out.println(hello);
    }

    public int getStringLength(String chars) {
        return chars.length();
    }

    public String reverseString(String s) {
        int len = s.length();
        char[] tempArr = new char[len];
        char[] reverseArr = new char[len];

        // create a temp array from the original string
        s.getChars(0, len, tempArr, 0);

        // reverse temp array
        for (int i = 0; i < len; i++) {
            reverseArr[i] = tempArr[len - 1 - i];
        }
        String result = new String(reverseArr);
        System.out.println(result);
        return result;
    }

    public String concatStrings(String s1, String s2) {
        return s1.concat(s2);
    }

    public String createFormatString(float floatVar, int intVar, String stringVar) {
        return String.format("The value of the float " +
                        "variable is %f, while " +
                        "the value of the " +
                        "integer variable is %d, " +
                        " and the string is %s",
                floatVar, intVar, stringVar);
    }
}
