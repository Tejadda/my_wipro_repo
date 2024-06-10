package com.DAY_27;
public class CustomStringUtility {
    public String concatenate(String str1, String str2) {
        return str1 + str2;
    }

    public boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public String toUpperCase(String str) {
        return str.toUpperCase();
    }

    public boolean contains(String str, String substr) {
        return str.contains(substr);
    }
}


package com.DAY_27;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CustomStringUtilityTest {
    private CustomStringUtility customStringUtility = new CustomStringUtility();

    @Test
    void testConcatenate() {
        assertEquals("HelloWorld", customStringUtility.concatenate("Hello", "World"));
        assertEquals("Hello", customStringUtility.concatenate("Hello", ""));
        assertEquals("", customStringUtility.concatenate("", ""));
    }

    @Test
    void testIsEmpty() {
        assertTrue(customStringUtility.isEmpty(null));
        assertTrue(customStringUtility.isEmpty(""));
        assertFalse(customStringUtility.isEmpty("Hello"));
    }

    @Test
    void testToUpperCase() {
        assertEquals("HELLO", customStringUtility.toUpperCase("hello"));
        assertEquals("", customStringUtility.toUpperCase(""));
        assertEquals("", customStringUtility.toUpperCase(""));
    }

    @Test
    void testContains() {
        assertTrue(customStringUtility.contains("Hello World", "World"));
        assertFalse(customStringUtility.contains("Hello World", "Universe"));
        assertFalse(customStringUtility.contains("hello", "World"));
        assertFalse(customStringUtility.contains("Hello World", "world"));
    }
}
