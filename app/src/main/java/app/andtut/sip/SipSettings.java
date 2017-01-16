package app.andtut.sip;

/**
 * Created by tuannt on 16/01/2017.
 * Project: android-tutorial
 * Package: app.andtut.sip
 */
import android.os.Bundle;
import android.preference.PreferenceActivity;

import app.andtut.R;

/**
 * Handles SIP authentication settings for the Walkie Talkie app.
 */
public class SipSettings extends PreferenceActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // Note that none of the preferences are actually defined here.
        // They're all in the XML file res/xml/preferences.xml.
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}