package ch.almana.android.compass;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.util.Log;

public class CompassService extends Service {

	private static final int NOTIFICATION_COMPASS = 1;

	private Notification notification;

	private PendingIntent contentIntent;

	private CharSequence contentTitle;

	private CharSequence contentText;

	private NotificationManager mNotificationManager;

	private SensorManager mSensorManager;

	@SuppressWarnings("deprecation")
	private final SensorListener mListener = new SensorListener() {

		private float oldOrientation;

		@Override
		public void onAccuracyChanged(int sensor, int accuracy) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onSensorChanged(int sensor, float[] values) {
			float o = values[0];
			if (Math.abs(o - oldOrientation) > 10) {
				notifyStatus(o);
				oldOrientation = o;
			}

		}
	};

	private Context context;

	public static void startService(Context context) {
		Intent i = new Intent(context, CompassService.class);
		context.startService(i);
	}

	public static void stopService(Context context) {
		Intent i = new Intent(context, CompassService.class);
		context.stopService(i);
	}

	@Override
	public void onStart(Intent intent, int startId) {
		// if (ACTION_SET_REFERENCE_LOCATION.equals(intent.getAction())) {
		// setReferencePoint(getLocation());
		// } else {

		super.onStart(intent, startId);
		// }
	}

	@Override
	public void onDestroy() {
		mNotificationManager.cancel(NOTIFICATION_COMPASS);
		mSensorManager.unregisterListener(mListener);
		super.onDestroy();
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Log.i(Logger.TAG, "Starting statusbar compass");
		context = getApplicationContext();

		String ns = Context.NOTIFICATION_SERVICE;
		mNotificationManager = (NotificationManager) getSystemService(ns);
		int icon = R.drawable.arrow0;
		CharSequence tickerText = "";
		long when = System.currentTimeMillis();

		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		mSensorManager.registerListener(mListener, SensorManager.SENSOR_ORIENTATION, SensorManager.SENSOR_DELAY_UI);

		notification = new Notification(icon, tickerText, when);

		contentTitle = "Compass";
		Intent notificationIntent = new Intent(this, ConfigActivity.class);
		contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

		// RemoteViews contentView = new RemoteViews(getPackageName(),
		// R.layout.nothing);
		// notification.contentView = contentView;

		notification.flags |= Notification.FLAG_NO_CLEAR;
		notification.flags |= Notification.FLAG_ONGOING_EVENT;

		notifyStatus(0);

	}

	private void notifyStatus(float value) {
		int orientation = (int) Math.round(value / 10f);
		if (orientation > -1) {
			contentText = "Compass angle " + orientation + " °";
			int img = getImageResId(orientation);
			if (img > -1) {
				notification.icon = img;
				notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
				mNotificationManager.notify(NOTIFICATION_COMPASS, notification);
			}
		}
	}

	private int getImageResId(int orientation) {
		int img;
		switch (orientation) {
		case 0:
			img = R.drawable.arrow0;
			break;
		case 1:
			img = R.drawable.arrow1;
			break;
		case 2:
			img = R.drawable.arrow2;
			break;
		case 3:
			img = R.drawable.arrow3;
			break;
		case 4:
			img = R.drawable.arrow4;
			break;
		case 5:
			img = R.drawable.arrow5;
			break;
		case 6:
			img = R.drawable.arrow6;
			break;
		case 7:
			img = R.drawable.arrow7;
			break;
		case 8:
			img = R.drawable.arrow8;
			break;
		case 9:
			img = R.drawable.arrow9;
			break;
		case 10:
			img = R.drawable.arrow10;
			break;
		case 11:
			img = R.drawable.arrow11;
			break;
		case 12:
			img = R.drawable.arrow12;
			break;
		case 13:
			img = R.drawable.arrow13;
			break;
		case 14:
			img = R.drawable.arrow14;
			break;
		case 15:
			img = R.drawable.arrow15;
			break;
		case 16:
			img = R.drawable.arrow16;
			break;
		case 17:
			img = R.drawable.arrow17;
			break;
		case 18:
			img = R.drawable.arrow18;
			break;
		case 19:
			img = R.drawable.arrow19;
			break;
		case 20:
			img = R.drawable.arrow20;
			break;
		case 21:
			img = R.drawable.arrow21;
			break;
		case 22:
			img = R.drawable.arrow22;
			break;
		case 23:
			img = R.drawable.arrow23;
			break;
		case 24:
			img = R.drawable.arrow24;
			break;
		case 25:
			img = R.drawable.arrow25;
			break;
		case 26:
			img = R.drawable.arrow26;
			break;
		case 27:
			img = R.drawable.arrow27;
			break;
		case 28:
			img = R.drawable.arrow28;
			break;
		case 29:
			img = R.drawable.arrow29;
			break;
		case 30:
			img = R.drawable.arrow30;
			break;
		case 31:
			img = R.drawable.arrow31;
			break;
		case 32:
			img = R.drawable.arrow32;
			break;
		case 33:
			img = R.drawable.arrow33;
			break;
		case 34:
			img = R.drawable.arrow34;
			break;
		case 35:
			img = R.drawable.arrow35;
			break;
		case 36:
			img = R.drawable.arrow0;
			break;
		default:
			img = -1;
			break;
		}
		return img;
	}

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
