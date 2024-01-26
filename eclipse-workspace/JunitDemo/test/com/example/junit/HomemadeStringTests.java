package com.example.junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomemadeStringTests {
    // Test 1: Testing length() method for HomemadeString
    @Test
    public void testHomemadeStringLength() {
        char[] data = "Hello, HomemadeString!".toCharArray();
        HomemadeString homemadeStr = new HomemadeString(data);
        assertEquals(22, homemadeStr.length());
    }

    // Test 2: Testing substring() method for HomemadeString
    @Test
    public void testHomemadeStringSubstring() {
        char[] data = "Hello, HomemadeString!".toCharArray();
        HomemadeString homemadeStr = new HomemadeString(data);
        assertEquals("HomemadeString", homemadeStr.substring(7, 23));
    }

    // Test 3: Testing contains() method for HomemadeString
    @Test
    public void testHomemadeStringContains() {
        char[] data = "This is a HomemadeString example.".toCharArray();
        HomemadeString homemadeStr = new HomemadeString(data);
        
        assertTrue(homemadeStr.contains("HomemadeString"));
        assertTrue(homemadeStr.contains("is a"));
        assertTrue(homemadeStr.contains("example."));
        assertFalse(homemadeStr.contains("nonexistent"));
    }
}