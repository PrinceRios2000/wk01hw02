package com.example.wk01hw02;

import static org.junit.Assert.assertEquals;

import android.content.Context;
import android.content.Intent;

import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Test;

public class WK01HW02Test {
    @Test
    public void verifyIntent() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Intent intent = LandingPageActivity.getIntent(appContext, "1", "Bret");
        intent.putExtra("Test", "intentWithData");
        assertEquals("intentWithData", intent.getStringExtra("Test"));
        intent = new Intent();
        intent.putExtra("Test1", "intentWithData2");
        assertEquals("intentWithData2", intent.getStringExtra("Test1"));
    }
}

