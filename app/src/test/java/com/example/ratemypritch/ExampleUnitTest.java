package com.example.ratemypritch;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class ExampleUnitTest {
    @Test

    public void DatabaseExists() {
        assertEquals(DB_Helper.DBNAME, "Login.db");
    }
}
