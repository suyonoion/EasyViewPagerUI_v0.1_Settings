package com.suyonoion.easyviewpagerui;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import eu.chainfire.libsuperuser.Shell;

/**
 * Created by Suyono on 6/6/2015.
 * Copyright (c) 2015 by Suyono (ion).
 * All rights reserved.
 * This product is protected by copyright and distributed under
 * licenses restricting copying, distribution and decompilation.
 */
public class RestartUI extends Activity {
    public Button yes, no, reboot,recv,shut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setResource("dialog","layout"));

        reboot = (Button) findViewById(setResource("btn_reb","id"));
        recv = (Button) findViewById(setResource("btn_rec","id"));
        shut = (Button) findViewById(setResource("shut","id"));
        yes = (Button) findViewById(setResource("btn_yes","id"));
        no = (Button) findViewById(setResource("btn_no","id"));

        reboot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (new StartUp()).setContext(v.getContext()).execute("reboot");
            }
        });
        recv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (new StartUp()).setContext(v.getContext()).execute("recov");
            }
        });
        shut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (new StartUp()).setContext(v.getContext()).execute("shutdown");
            }
        });
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (new StartUp()).setContext(v.getContext()).execute("sysui");
                finish();
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private class StartUp extends AsyncTask<String,Void,Void> {


        private Context context = null;
        boolean suAvailable = false;
        public StartUp setContext(Context context) {
            this.context = context;
            return this;
        }

        @Override
        protected Void doInBackground(String... params) {
            suAvailable = Shell.SU.available();
            if (suAvailable) {

                // suResult = Shell.SU.run(new String[] {"cd data; ls"}); Shell.SU.run("reboot");
                switch (params[0]){
                    case "reboot"  : Shell.SU.run("reboot");break;
                    case "recov"   : Shell.SU.run("reboot recovery");break;
                    case "shutdown": Shell.SU.run("reboot -p");break;
                    //case "sysui"   : Shell.SU.run("am startservice -n com.android.systemui/.SystemUIService");break;
                    case "sysui"   : Shell.SU.run("pkill com.android.systemui");break;
                }
            }
            else{
                Toast.makeText(getApplicationContext(), "Phone not Rooted /n Sebaiknya di Root dulu HH nya ya gan :)", Toast.LENGTH_SHORT).show();
            }

            return null;
        }
    }

    public int setResource(String name, String Type)
    {
        return getBaseContext().getResources().getIdentifier(name, Type, getBaseContext().getPackageName());
    }

    public void onResume() {
        super.onResume();
        this.onCreate(null);
    }
}
