package com.vamsi;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testAdd() {

        App app = new App();

        assertEquals(10, app.add(5,5));
    }
}
