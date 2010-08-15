package ch.almana.android.compass;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BootReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// called on system boot
		Log.i(Logger.TAG, "BootReceive onReceive -> system boot?");
		if (SettingsHelper.getSettings(context).isBootstart()) {
			CompassService.startService(context);
		}
	}

}
