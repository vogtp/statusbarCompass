package ch.almana.android.compass;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class SettingsHelper {

	private static final String PREF_KEY_BOOTSTART = "bootStart";

	private static SettingsHelper instance = null;

	private SharedPreferences defaultSharedPreferences = null;
	private Context context;

	public static SettingsHelper getSettings(Context ctx) {
		if (instance == null) {
			instance = new SettingsHelper(ctx.getApplicationContext());
		}
		return instance;
	}

	public SettingsHelper(Context ctx) {
		super();
		this.context = ctx;
	}

	private SharedPreferences getPreferences() {
		if (defaultSharedPreferences == null) {
			defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
		}
		return defaultSharedPreferences;
	}

	public boolean isBootstart() {
		return getPreferences().getBoolean(PREF_KEY_BOOTSTART, false);
	}

	public void setBootstart(boolean bootstart) {
		Editor edit = getPreferences().edit();
		edit.putBoolean(PREF_KEY_BOOTSTART, bootstart);
		edit.commit();
	}
}
