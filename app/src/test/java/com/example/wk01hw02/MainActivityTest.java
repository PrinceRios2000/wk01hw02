package com.example.wk01hw02;
import static org.junit.Assert.*;

import org.junit.Test;

public class MainActivityTest {
    @Test
    public void checkUsername() {
        String username = "Antonette";
        assertEquals(true, MainActivity.checkUsername(username, "Antonette"));
    }

    @Test
    public void checkPassword() {
        String password = "kam";
        assertEquals(true, MainActivity.checkUsername(password, "kam"));
    }

}
