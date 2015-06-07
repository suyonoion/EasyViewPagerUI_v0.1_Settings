package com.suyonoion.easyviewpagerui;

import android.app.Activity;
import android.os.Bundle;


public class MainActivity extends Activity {
    public int setResource(String name, String Type)
    {
        return getBaseContext().getResources().getIdentifier(name, Type, getBaseContext().getPackageName());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setResource("activity_main","layout"));

    }

    public void onResume() {
        super.onResume();
        this.onCreate(null);
    }

}
