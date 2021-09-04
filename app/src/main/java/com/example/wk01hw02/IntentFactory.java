package com.example.wk01hw02;

import android.content.Context;
import android.content.Intent;

public class IntentFactory {
    public static Intent getIntent(String className,
                                   Context context,
                                   String id_val,
                                   String user_val) {
        switch (className) {
            case "LandingActivity":
                return LandingPageActivity.getIntent(context, id_val, user_val);
            default:
                return new Intent(context, MainActivity.class);
        }
    }
}
