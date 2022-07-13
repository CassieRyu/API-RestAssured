/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.rest.assured.specs;

import com.rest.assured.Library;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class LibraryTest {
    @Test(groups = "Library", description = "Sanity check sample.")
    public void someLibraryMethodReturnsTrue() {
        Library classUnderTest = new Library();
        assertTrue(classUnderTest.someLibraryMethod(), "someLibraryMethod should return 'true'");
    }
}
