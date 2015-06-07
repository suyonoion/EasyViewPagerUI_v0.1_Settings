package com.suyonoion.easyviewpagerui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Suyono on 5/26/2015.
 * Copyright (c) 2015 by Suyono (ion).
 * All rights reserved.
 * This product is protected by copyright and distributed under
 * licenses restricting copying, distribution and decompilation.
 */
public class CopyKode extends LinearLayout {

    Button copy0;
    EditText copyTxt0;
    int sdk = android.os.Build.VERSION.SDK_INT;

    public int setResource(String name, String Type)
    {
        return getContext().getResources().getIdentifier(name, Type, getContext().getPackageName());
    }

    public CopyKode(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View root = inflater.inflate(setResource("copykode","layout"), this, true);
        ImageView ion = (ImageView) root.findViewById(setResource("github", "id"));
        ion.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://github.com/suyonoion/EasyViewPagerUI_v0.1_Settings";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                i.setData(Uri.parse(url));
                getContext().startActivity(i);
            }
        });

        copy0 = (Button) root.findViewById(setResource("copy0","id"));
        copyTxt0 = (EditText) root.findViewById(setResource("copytxt0","id"));
        copy0.setOnClickListener(new OnClickListener() {
            String CopyText0;
            @SuppressWarnings("deprecation")
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                CopyText0 = copyTxt0.getText().toString();
                if (CopyText0.length() != 0) {
                    if (sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
                        android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                        clipboard.setText(CopyText0);
                        Toast.makeText(getContext(), "Text Telah Ter-Copy ke Clipboard", Toast.LENGTH_SHORT).show();
                    } else {
                        android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                        android.content.ClipData clip = android.content.ClipData.newPlainText("Clip", CopyText0);
                        Toast.makeText(getContext(), "Text Telah Ter-Copy ke Clipboard", Toast.LENGTH_SHORT).show();
                        clipboard.setPrimaryClip(clip);
                    }
                } else {
                    Toast.makeText(getContext(), "Text kosong, tidak ada apapun yang ter-Copy", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}

