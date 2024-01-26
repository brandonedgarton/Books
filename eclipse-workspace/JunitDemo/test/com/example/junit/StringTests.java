package com.example.junit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class StringTests {
    // Test 1: Testing length() method
    @Test
    public void testStringLength() {
        String str = "Hello, World!";
        assertEquals(13, str.length());
    }

    @Test
    public void testStringLengthEmpty() {
        String str = "";
        assertEquals(0, str.length());
    }

    @Test
    public void testStringLengthNull() {
        String str = null;
        assertEquals(0, str.length());
    }

    // Test 2: Testing substring() method
    @Test
    public void testSubstring() {
        String str = "Hello, World!";
        assertEquals("Hello", str.substring(0, 5));
    }

    @Test
    public void testSubstringOutOfBounds() {
        String str = "Hello, World!";
        assertEquals("", str.substring(13, 15));
    }

    @Test
    public void testSubstringNegativeStart() {
        String str = "Hello, World!";
        assertEquals("Hello, World!", str.substring(-5, 13));
    }

    // Test 3: Testing contains() method
    @Test
    public void testContains() {
        String str = "Hello, World!";
        assertTrue(str.contains("World"));
    }

    @Test
    public void testContainsEmpty() {
        String str = "Hello, World!";
        assertFalse(str.contains(""));
    }

    @Test
    public void testContainsNull() {
        String str = "Hello, World!";
        assertFalse(str.contains(null));
    }
    
    // Test 4: Testing indexOf() method
    @Test
    public void testIndexOf() {
        String str = "Hello, World!";
        assertEquals(0, str.indexOf("Hello"));
    }

    @Test
    public void testIndexOfNonexistent() {
        String str = "Hello, World!";
        assertEquals(-1, str.indexOf("Java"));
    }

    @Test
    public void testIndexOfFromIndex() {
        String str = "Hello, World!";
        assertEquals(7, str.indexOf("World", 5));
    }

    // Test 5: Testing equals() method
    @Test
    public void testEquals() {
        String str1 = "Hello, World!";
        String str2 = "Hello, World!";
        assertTrue(str1.equals(str2));
    }

    @Test
    public void testNotEquals() {
        String str1 = "Hello, World!";
        String str2 = "Hello, Java!";
        assertFalse(str1.equals(str2));
    }

    @Test
    public void testEqualsIgnoreCase() {
        String str1 = "Hello, World!";
        String str2 = "hello, world!";
        assertTrue(str1.equalsIgnoreCase(str2));
    }


    // Test 6: Testing replace() method
    @Test
    public void testReplace() {
        String str = "Hello, World!";
        String replacedStr = str.replace("World", "Java");
        assertEquals("Hello, Java!", replacedStr);
    }

    @Test
    public void testReplaceMultipleOccurrences() {
        String str = "Hello, World! World is great!";
        String replacedStr = str.replace("World", "Java");
        assertEquals("Hello, Java! Java is great!", replacedStr);
    }

    @Test
    public void testReplaceNonexistent() {
        String str = "Hello, World!";
        String replacedStr = str.replace("Java", "Universe");
        assertEquals("Hello, World!", replacedStr);
    }

    // Test 7: Testing toLowerCase() method
    @Test
    public void testToLowerCase() {
        String str = "Hello, World!";
        String lowerCaseStr = str.toLowerCase();
        assertEquals("hello, world!", lowerCaseStr);
    }

    @Test
    public void testToLowerCaseEmpty() {
        String str = "";
        String lowerCaseStr = str.toLowerCase();
        assertEquals("", lowerCaseStr);
    }

    @Test
    public void testToLowerCaseWithSpecialChars() {
        String str = "HELLO123, WoRLd@";
        String lowerCaseStr = str.toLowerCase();
        assertEquals("hello123, world@", lowerCaseStr);
    }

    // Test 8: Testing toUpperCase() method
    @Test
    public void testToUpperCase() {
        String str = "Hello, World!";
        String upperCaseStr = str.toUpperCase();
        assertEquals("HELLO, WORLD!", upperCaseStr);
    }

    @Test
    public void testToUpperCaseEmpty() {
        String str = "";
        String upperCaseStr = str.toUpperCase();
        assertEquals("", upperCaseStr);
    }

    @Test
    public void testToUpperCaseWithSpecialChars() {
        String str = "hello123, world@";
        String upperCaseStr = str.toUpperCase();
        assertEquals("HELLO123, WORLD@", upperCaseStr);
    }

    // Test 9: Testing trim() method
    @Test
    public void testTrim() {
        String str = "  Hello, World!   ";
        String trimmedStr = str.trim();
        assertEquals("Hello, World!", trimmedStr);
    }

    @Test
    public void testTrimNoLeadingTrailingSpaces() {
        String str = "Hello, World!";
        String trimmedStr = str.trim();
        assertEquals("Hello, World!", trimmedStr);
    }

    @Test
    public void testTrimOnlySpaces() {
        String str = "     ";
        String trimmedStr = str.trim();
        assertEquals("", trimmedStr);
    }

    // Test 10: Testing startsWith() method
    @Test
    public void testStartsWith() {
        String str = "Hello, World!";
        assertTrue(str.startsWith("Hello"));
    }

    @Test
    public void testStartsWithNonexistent() {
        String str = "Hello, World!";
        assertFalse(str.startsWith("World"));
    }

    @Test
    public void testStartsWithEmptyPrefix() {
        String str = "Hello, World!";
        assertTrue(str.startsWith(""));
    }

}
