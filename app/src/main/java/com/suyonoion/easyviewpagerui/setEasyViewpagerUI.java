package com.suyonoion.easyviewpagerui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

public class setEasyViewpagerUI extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener
{
    String title = "Pemberitahuan";
    String message = "Setelah selesai edit, jangan lupa untuk me-Restart SystemUI...!!";

    public int setResource(String name, String Type)
    {
        return getBaseContext().getResources().getIdentifier(name, Type, getBaseContext().getPackageName());
    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        addPreferencesFromResource(setResource("pref_easyviewpagerui","xml"));
        PreferenceManager.getDefaultSharedPreferences(this).registerOnSharedPreferenceChangeListener(this);
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setMessage(message);
        b.setCancelable(false);
        b.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        b.setTitle(title);
        AlertDialog ad = b.create();
        ad.show();
    }

    @Override
    public void onResume(){
        super.onResume();
        final String key="getCount";
        ListPreference listPreference=(ListPreference)findPreference(key);
        final String values=PreferenceManager.getDefaultSharedPreferences(this).getString(key,key);
        final int index=listPreference.findIndexOfValue(values);
        if (index>=0){
            final String summary = (String) listPreference.getEntries()[index];
            listPreference.setSummary(summary);
        }

        final String keybgvp="setBackgroundVP";
        ListPreference listPreferencebgvp=(ListPreference)findPreference(keybgvp);
        final String valuesbgvp=PreferenceManager.getDefaultSharedPreferences(this).getString(keybgvp,keybgvp);
        final int indexbgvp=listPreferencebgvp.findIndexOfValue(valuesbgvp);
        if (indexbgvp>=0){
            final String summarybgvp = (String) listPreferencebgvp.getEntries()[indexbgvp];
            listPreferencebgvp.setSummary(summarybgvp);
        }

        final String keyrotasi="setrotasi";
        ListPreference listPreferencerotasi=(ListPreference)findPreference(keyrotasi);
        final String valuesrotasi=PreferenceManager.getDefaultSharedPreferences(this).getString(keyrotasi,keyrotasi);
        final int indexrotasi=listPreferencerotasi.findIndexOfValue(valuesrotasi);
        if (indexrotasi>=0){
            final String summaryrotasi = (String) listPreferencerotasi.getEntries()[indexrotasi];
            listPreferencerotasi.setSummary(summaryrotasi);
        }

        SharedPreferences setJudulSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        final String key1="setJudul1";
        final String key2="setJudul2";
        final String key3="setJudul3";
        final String key4="setJudul4";
        final String key5="setJudul5";
        final String key6="setJudul6";
        final String key7="setJudul7";

        String isikanJudul1 = setJudulSharedPreferences.getString(key1, "Page 1");
        String isikanJudul2 = setJudulSharedPreferences.getString(key2, "Page 2");
        String isikanJudul3 = setJudulSharedPreferences.getString(key3, "Page 3");
        String isikanJudul4 = setJudulSharedPreferences.getString(key4, "Page 4");
        String isikanJudul5 = setJudulSharedPreferences.getString(key5, "Page 5");
        String isikanJudul6 = setJudulSharedPreferences.getString(key6, "Page 6");
        String isikanJudul7 = setJudulSharedPreferences.getString(key7, "Page 7");

        Preference pref_judul1= findPreference(key1);
        Preference pref_judul2= findPreference(key2);
        Preference pref_judul3= findPreference(key3);
        Preference pref_judul4= findPreference(key4);
        Preference pref_judul5= findPreference(key5);
        Preference pref_judul6= findPreference(key6);
        Preference pref_judul7= findPreference(key7);
        
        pref_judul1.setSummary(isikanJudul1);
        pref_judul2.setSummary(isikanJudul2);
        pref_judul3.setSummary(isikanJudul3);
        pref_judul4.setSummary(isikanJudul4);
        pref_judul5.setSummary(isikanJudul5);
        pref_judul6.setSummary(isikanJudul6);
        pref_judul7.setSummary(isikanJudul7);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences options, String key) {
        if (key.equals("getCount")){
            ListPreference listPreference=(ListPreference)findPreference(key);
            final String values=options.getString(key,key);
            final int index=listPreference.findIndexOfValue(values);
            if (index>=0){
                final String summary = (String) listPreference.getEntries()[index];
                listPreference.setSummary(summary);
            }
        }

        if (key.equals("setBackgroundVP")){
            ListPreference listPreferencebgvp=(ListPreference)findPreference(key);
            final String valuesbgvp=options.getString(key,key);
            final int indexbgvp=listPreferencebgvp.findIndexOfValue(valuesbgvp);
            if (indexbgvp>=0){
                final String summarybgvp = (String) listPreferencebgvp.getEntries()[indexbgvp];
                listPreferencebgvp.setSummary(summarybgvp);
            }
        }

        if (key.equals("setrotasi")){
            ListPreference listPreferencerotasi=(ListPreference)findPreference(key);
            final String valuesrotasi=options.getString(key,key);
            final int indexrotasi=listPreferencerotasi.findIndexOfValue(valuesrotasi);
            if (indexrotasi>=0){
                final String summarybgvp = (String) listPreferencerotasi.getEntries()[indexrotasi];
                listPreferencerotasi.setSummary(summarybgvp);
            }
        }

        if (key.equals("setJudul1")){
            Preference pref_judul1= findPreference(key);
            String isikanJudul1 = options.getString(key,"Page 1");
            pref_judul1.setSummary(isikanJudul1);        
        }

        if (key.equals("setJudul2")){
            Preference pref_judul2= findPreference(key);
            String isikanJudul2 = options.getString(key,"Page 2");
            pref_judul2.setSummary(isikanJudul2);
        }

        if (key.equals("setJudul3")){
            Preference pref_judul3= findPreference(key);
            String isikanJudul3 = options.getString(key,"Page 3");
            pref_judul3.setSummary(isikanJudul3);
        }

        if (key.equals("setJudul4")){
            Preference pref_judul4= findPreference(key);
            String isikanJudul4 = options.getString(key,"Page 4");
            pref_judul4.setSummary(isikanJudul4);
        }

        if (key.equals("setJudul5")){
            Preference pref_judul5= findPreference(key);
            String isikanJudul5 = options.getString(key,"Page 5");
            pref_judul5.setSummary(isikanJudul5);
        }

        if (key.equals("setJudul6")){
            Preference pref_judul6= findPreference(key);
            String isikanJudul6 = options.getString(key,"Page 6");
            pref_judul6.setSummary(isikanJudul6);
        }

        if (key.equals("setJudul7")){
            Preference pref_judul7= findPreference(key);
            String isikanJudul7 = options.getString(key,"Page 7");
            pref_judul7.setSummary(isikanJudul7);
        }

    }

}