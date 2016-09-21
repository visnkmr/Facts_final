package com.sortedcode.apps.Facts;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class FactSettings extends com.fnp.materialpreferences.PreferenceActivity{

    public String filename = "MySharedString";
    SharedPreferences someData;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);
        addPreferencesFromResource(R.xml.preferences);
        someData = getSharedPreferences(filename,0);
        Preference dialogPreference = findPreference("dialog_preference");
        dialogPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(FactSettings.this,R.style.MyAlertDialogStyle);
                alertDialog.setIcon(R.drawable.ic_launcher);
                alertDialog.setTitle("Enter Fact number");
                final EditText input = new EditText(FactSettings.this);
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                alertDialog.setView(input);
                alertDialog.setPositiveButton("Take me to the fact",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        int setfactnum = 0;
                        int k=1;
                        try {
                            setfactnum = Integer.parseInt(input.getText().toString());
                        } catch (NumberFormatException ex)
                        {
                            k=0;
                        }

                        String factno = "nfactfile";
                        SharedPreferences factcount;
                        factcount = getSharedPreferences(factno,0);
                        Integer fnocheck = factcount.getInt("factcount",1);
                        fnocheck++;
                        if (setfactnum<fnocheck && setfactnum>0 )
                        { SharedPreferences.Editor editor = someData.edit();
                            editor.putInt("ivalue", setfactnum-1 );
                            editor.apply();
                            Intent myIntent1 = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(myIntent1);
                        } else {
                            k=0;
                        }
                        if(k==0){
                            Toast toast = Toast.makeText(getApplicationContext(),"Enter a valid fact number!", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 10, 0);
                            toast.show();
                        }
                    }
                });
                alertDialog.show();
                return true;
            }
        });
        Preference helpPreference = findPreference("help_preference");
        helpPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                Intent intent = new Intent(getApplicationContext(), intro4.class);
                startActivity(intent);
                return true;
            }
        });
        Preference emaildevPreference = findPreference("emaildev_preference");
        emaildevPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","visnk2@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "");
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
                return true;
            }
        });
        Preference fixspeechPreference = findPreference("fixspeech_preference");
        fixspeechPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                new AlertDialog.Builder(FactSettings.this,R.style.MyAlertDialogStyle)
                        .setIcon(R.drawable.speak)
                        .setTitle("Fix Speech")
                        .setMessage("If you dont hear any voice go to" +
                                "                        \n->setting (of your android device)" +
                                "                        \n->accessibility" +
                                "                        \n->text-to-speech output" +
                                "                        \n->gear icon (settings icon) near 'Google Text-to-speech engine'" +
                                "                        \n->Language->English(United States)")
                        .setPositiveButton("ok", null)
                        .show();
                return true;
            }
        });
    }
    public void onBackPressed() {
        finishAffinity();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

}