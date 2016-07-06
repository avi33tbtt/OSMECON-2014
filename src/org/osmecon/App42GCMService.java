/**
 * 
 */
package org.osmecon;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

import com.google.android.gcm.GCMBaseIntentService;
import com.google.android.gcm.GCMRegistrar;
import com.shephertz.app42.paas.sdk.android.App42API;
import com.shephertz.app42.paas.sdk.android.App42CallBack;
import com.shephertz.app42.paas.sdk.android.App42Log;

/**
 * @author Ajay Tiwari
 * 
 */
public class App42GCMService extends GCMBaseIntentService {
	public static String PROJECT_NUMBER = "122629890352";
	// static final String LARGE_IMAGE_URL = "@drawable/ico";
	static int msgCount = 0;

	/**
	 * Intent used to display a message in the screen.
	 */
	static final String DISPLAY_MESSAGE_ACTION = "org.osmecon.DISPLAY_MESSAGE";

	/**
	 * Intent's extra that contains the message to be displayed.
	 */
	static final String EXTRA_MESSAGE = "message";

	public App42GCMService() {
		super(PROJECT_NUMBER);
	}

	@Override
	protected void onError(Context arg0, String msg) {

	}

	@Override
	protected void onMessage(Context context, Intent intent) {

		String message = intent.getExtras().getString("message");
		displayMessage(context, message);
		generateNotification(context, message);
	}

	static void setSenderId(String senderId) {
		PROJECT_NUMBER = senderId;
	}

	@Override
	protected void onRegistered(Context arg0, String regId) {

		registerWithApp42(regId);

	}

	private void registerWithApp42(String regId) {
		App42Log.debug(" Registering on Server ....");
		App42API.buildPushNotificationService().storeDeviceToken(
				App42API.getLoggedInUser(), regId, new App42CallBack() {
					@Override
					public void onSuccess(Object paramObject) {
						// TODO Auto-generated method stub
						App42Log.debug(" ..... Registeration Success ....");
						GCMRegistrar.setRegisteredOnServer(App42API.appContext,
								true);
					}

					@Override
					public void onException(Exception paramException) {
						App42Log.debug(" ..... Registeration Failed ....");
						App42Log.debug("storeDeviceToken :  Exception : on start up "
								+ paramException);

					}
				});

	}

	@Override
	protected void onUnregistered(Context arg0, String arg1) {

	}

	/**
	 * Notifies UI to display a message.
	 * <p>
	 * This method is defined in the common helper because it's used both by the
	 * UI and the background service.
	 * 
	 * @param context
	 *            application's context.
	 * @param message
	 *            message to be displayed.
	 */
	public void displayMessage(Context context, String message) {
		Intent intent = new Intent(DISPLAY_MESSAGE_ACTION);
		intent.putExtra(EXTRA_MESSAGE, message);
		context.sendBroadcast(intent);
	}

	public static void resetMsgCount() {
		msgCount = 0;
	}

	/**
	 * Issues a notification to inform the user that server has sent a message.
	 */
	public void generateNotification(Context context, String message) {
		int icon = R.drawable.ico;
		long when = System.currentTimeMillis();
		ComponentName myService = new ComponentName(this, this.getClass());
		String activityName = null;
		try {
			Bundle data = getPackageManager().getServiceInfo(myService,
					PackageManager.GET_META_DATA).metaData;
			App42Log.debug(" Message Activity Name : "
					+ data.getString("onMessageOpen"));
			activityName = data.getString("onMessageOpen");
		} catch (NameNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		NotificationManager notificationManager = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		String title = context.getString(R.string.app_name);
		Intent notificationIntent;
		try {
			notificationIntent = new Intent(context,
					Class.forName(activityName));
			notificationIntent.putExtra("message_delivered", true);
			notificationIntent.putExtra(EXTRA_MESSAGE, message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			notificationIntent = new Intent(context, MessageActivity.class);

		}
		// set intent so it does not start a new activity
		notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
				| Intent.FLAG_ACTIVITY_SINGLE_TOP);
		PendingIntent intent = PendingIntent.getActivity(context, 0,
				notificationIntent, PendingIntent.FLAG_CANCEL_CURRENT);

		Notification notification = new NotificationCompat.Builder(context)
				.setContentTitle(title).setContentText(message)
				.setContentIntent(intent).setSmallIcon(icon).setWhen(when)
				.setNumber(++msgCount)
				// .setLargeIcon(getBitmapFromURL(LARGE_IMAGE_URL))
				.setLights(Color.YELLOW, 1, 2).setAutoCancel(true).build();

		notification.defaults |= Notification.DEFAULT_SOUND;
		notification.defaults |= Notification.DEFAULT_VIBRATE;
		notificationManager.notify(0, notification);
	}

	public static Bitmap getBitmapFromURL(String src) {
		try {
			URL url = new URL(src);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoInput(true);
			connection.connect();
			InputStream input = connection.getInputStream();
			Bitmap myBitmap = BitmapFactory.decodeStream(input);
			return myBitmap;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
