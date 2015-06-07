package com.suyonoion.easyviewpagerui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Suyono on 5/26/2015.
 * Copyright (c) 2015 by Suyono (ion).
 * All rights reserved.
 * This product is protected by copyright and distributed under
 * licenses restricting copying, distribution and decompilation.
 */

public class ExpandedViewpagerUI extends ViewPager {

    private int NUM_VIEWS = 2;
    private PagerTabStrip Tempat_Judul;
    private List<String> Mengisi_Tempat_judul;
    public int setResource(String name, String Type)
    {
        return getContext().getResources().getIdentifier(name, Type, getContext().getPackageName());
    }

    public ExpandedViewpagerUI (Context context, AttributeSet attrs) {
        super(context, attrs);

        SharedPreferences setJudulSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String isikanJudul1 = setJudulSharedPreferences.getString("setJudul1", "Page 1");
        String isikanJudul2 = setJudulSharedPreferences.getString("setJudul2", "Page 2");
        String isikanJudul3 = setJudulSharedPreferences.getString("setJudul3", "Page 3");
        String isikanJudul4 = setJudulSharedPreferences.getString("setJudul4", "Page 4");
        String isikanJudul5 = setJudulSharedPreferences.getString("setJudul5", "Page 5");
        String isikanJudul6 = setJudulSharedPreferences.getString("setJudul6", "Page 6");
        String isikanJudul7 = setJudulSharedPreferences.getString("setJudul7", "Page 7");

        Tempat_Judul = (PagerTabStrip) findViewById(setResource("id_judul","id"));
        Mengisi_Tempat_judul = new ArrayList<String>();
        Mengisi_Tempat_judul.add(isikanJudul1);
        Mengisi_Tempat_judul.add(isikanJudul2);
        Mengisi_Tempat_judul.add(isikanJudul3);
        Mengisi_Tempat_judul.add(isikanJudul4);
        Mengisi_Tempat_judul.add(isikanJudul5);
        Mengisi_Tempat_judul.add(isikanJudul6);
        Mengisi_Tempat_judul.add(isikanJudul7);

        AdapterExpandedViewpagerUI adapter = new AdapterExpandedViewpagerUI(Mengisi_Tempat_judul);
        final ViewPager EasyExpandedViewPagerUI = (ViewPager) this.findViewById(setResource("id_viewpager","id"));

        SharedPreferences pref_setRotasi=PreferenceManager.getDefaultSharedPreferences(getContext());
        final String value_rotasi=pref_setRotasi.getString("setrotasi","90");
        PageTransformer animasi = new PageTransformer() {

            public boolean isPagingEnabled()
            {
                return true;
            }

            @Override
            public void transformPage(View view, float position) {
                float ion=Float.valueOf(value_rotasi);
                    final float rotation = (position < 0 ? ion : -ion) * Math.abs(position);
                    view.setAlpha(rotation > ion || rotation < -ion ? 0f : 1f);
                    view.setPivotX(position < 0f ? view.getWidth() : 0f);
                    view.setPivotY(view.getHeight() * 0.5f);
                    view.setRotationY(ion * position);
            }
        };

        EasyExpandedViewPagerUI.setPageTransformer(true,animasi);
        EasyExpandedViewPagerUI.setAdapter(adapter);

        SharedPreferences setCountJumlah = PreferenceManager.getDefaultSharedPreferences(getContext());
        String tampilCount = setCountJumlah.getString("getCount", "2");
        int myNumCount = 0;
        try {
            myNumCount = Integer.parseInt(tampilCount);
        } catch (NumberFormatException nfe) {
            TampilPemberitahuan(getContext(), "Pemberitahuan", "Oppps...!! Sepertinya string ini Tidak bisa diubah jadi int...!! " + nfe);
        }
        setN(myNumCount);

        SharedPreferences setBackgroundVP = PreferenceManager.getDefaultSharedPreferences(getContext());
        String backgroundVP = setBackgroundVP.getString("setBackgroundVP", "bingkai_halaman");
        EasyExpandedViewPagerUI.setBackgroundResource(setResource(backgroundVP,"drawable"));

        EasyExpandedViewPagerUI.setOffscreenPageLimit(NUM_VIEWS);
        adapter.notifyDataSetChanged();
    }

    private void TampilPemberitahuan(Context ctx, String title, String message) {

            AlertDialog.Builder b = new AlertDialog.Builder(ctx);
            b.setMessage(message);
            b.setCancelable(false);
            b.setNeutralButton("Coba lagi", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            b.setTitle(title);
            AlertDialog ad = b.create();
            ad.show();

    }


    public void setN(int N) {
        this.NUM_VIEWS = N;
    }


    public class AdapterExpandedViewpagerUI extends PagerAdapter {
        private List<String> adapterMengisi_Tempat_judul;
        public AdapterExpandedViewpagerUI(List<String> adapterMengisi_Tempat_judul) {
            this.adapterMengisi_Tempat_judul = adapterMengisi_Tempat_judul;
        }


        @Override
        public int getCount() {
            return NUM_VIEWS;
        }

            @Override
            public Object instantiateItem (ViewGroup container,int position){

                int tampilkanMenurutId = 0;
                switch (position) {
                    case 0:
                        tampilkanMenurutId = setResource("id_halaman_1", "id");

                        break;
                    case 1:
                        tampilkanMenurutId = setResource("id_halaman_2", "id");
                        break;
                    case 2:
                        tampilkanMenurutId = setResource("id_halaman_3", "id");
                        break;
                    case 3:
                        tampilkanMenurutId = setResource("id_halaman_4", "id");
                        break;
                    case 4:
                        tampilkanMenurutId = setResource("id_halaman_5", "id");
                        break;
                    case 5:
                        tampilkanMenurutId = setResource("id_halaman_6", "id");
                        break;
                    case 6:
                        tampilkanMenurutId = setResource("id_halaman_7", "id");
                        break;


                }

                return findViewById(tampilkanMenurutId);
            }

            @Override
            public CharSequence getPageTitle ( int position){
                return adapterMengisi_Tempat_judul.get(position);
            }

            @Override
            public boolean isViewFromObject (View arg0, Object arg1){
                return arg0 == arg1;
            }

            @Override
            public Parcelable saveState () {
                return null;
            }


    }


}
