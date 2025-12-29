# Strings

## Creating Strings

Strings are a sequence of characters, are objects and widely used in Java.
Java provide __String__ class to create and manipulate strings.

You can create a string using a **new** keyword, constructor or a string literal—a series of characters in your code
that is enclosed in double quotes. Java has thirteen constructors that allow you to init a string object's value.

> __Note:__ The **String** class is immutable in Java, so once a string object is created, it can not be changed.
> _String_ class provides some methods for modifying purpose. Since strings are immutable, what these methods really do
> is to create and return a new string that contains the result of operations.

## String Length

Methods used to obtain object information are known as accessor methods. One accessor method used with string to return
the number of characters contained in the string object is `length()`.

## Concatenating Strings

`String` class includes `concat()` method to concatenate two strings, which return a new string object.

```java
s1.concat(s2);
```

Strings are most commonly concanated with `+` operator. You can also concat string with mixed data types. Such a
concatenation can be a mixture of any objects. For each object that is not a String, its `toString()` method is called
to
convert it to a String.

From Java SE 15, you can write two-dimensional string literals:

```java
String html = """
        <html>
            <body>
                <p>Hello, world!</p>
            </body>
        </html>
        """;
```

## Creating Format Strings

The **String** class includes `format()` method to print output with formatted strings, which returns a string object
rather than a [PrintStream](https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/io/PrintStream.html)
object.

Using String's static `format()` method allows you to create a formatted string that you can reuse, as apposed to a
one-time print statement. For example, instead of

```java
System.out.printf("The value of the float "+
                          "variable is %f, while "+
                          "the value of the "+
                          "integer variable is %d, "+
                          "and the string is %s",
                  floatVar, intVar, stringVar);
```

you can write

```java
String fs;
fs =String.

format("The value of the float "+
               "variable is %f, while "+
               "the value of the "+
               "integer variable is %d, "+
               " and the string is %s",
       floatVar, intVar, stringVar);
IO.

println(fs);
```

## Convert Strings to Numbers

The `Number` subclasses that wrap primitive numeric types(`Byte`, `Integer`, `Double`, .etc.) each provide a class
method
named `parse{Type}()` that converts a string to an equivalent value.

For example:

```java
public int parseIntFromString(String s) {
    return Integer.parseInt(s);
}

public float parseFloatFromString(String s) {
    return Float.parseFloat(s);
}

```

In case you need to get an equivalent object, each wrapper numeric class provides a class method named `valueOf()` and
get primitive value using `xxxValue()` method. For example:

```java
Float a = Float.valueOf(args[0]);

// get primitive value
float v = a.floatValue();
```

The first approach is supposed faster, since it doesn't involve creating an object.

## Converting Numbers to Strings

Sometimes you need to perform an action on the string form of a number, there are several ways to convert number to
string
in Java:

```java
int v;

// concatenate with an empty string, conversion is handled for you
String vString = "" + v;
```

Each `Number` subclasses provide a `toString` method to achieve similar purpose:

```java
String vString = Integer.toString(v);
```

or simply:

```java
String vString = String.valueOf(v);
```

In the last approach, the JVM internally calls the `toString()` method of the corresponding wrapper class.

## Getting Characters and Substrings by Index

The _String_ class has a lot of useful methods to complete a task, such as substrings, string case changing, finding
character, ...

For example, `charAt` accessor method, return character at particular index.

```java
String aString = "Hello world!";

// return character at index 4, in this case it return 'o'
char aChar = aString.charAt(4);
```

There are two versions of `substring` method to get more than one consecutive character from a string
`substring(int beginIndex)` and `substring(int beginIndex, int endIndex)`
