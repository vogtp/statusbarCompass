package ch.almana.android.compass;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class ConfigActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.config);
		Button buStart = (Button) findViewById(R.id.ButtonStart);
		Button buStop = (Button) findViewById(R.id.ButtonStop);
		CheckBox cbBootstart = (CheckBox) findViewById(R.id.CheckBoxBootstart);
		buStart.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				CompassService.startService(ConfigActivity.this);
			}
		});
		buStop.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				CompassService.stopService(ConfigActivity.this);
			}
		});
		cbBootstart.setChecked(SettingsHelper.getSettings(this).isBootstart());
		cbBootstart.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				SettingsHelper.getSettings(ConfigActivity.this).setBootstart(isChecked);
			}
		});
	}
}
