package org.osmecon;

import com.google.android.gcm.GCMRegistrar;
import com.shephertz.app42.paas.sdk.android.App42API;
import com.shephertz.app42.paas.sdk.android.App42CallBack;

//import com.shephertz.app42.paas.sdk.android.App42Log;

public class Util {

	public static void registerWithApp42(String projectNo) {
		// App42Log.debug(" ..... Registeration Check ....");
		App42GCMService.setSenderId(projectNo);
		final String deviceRegId = GCMRegistrar
				.getRegistrationId(App42API.appContext);
		if (deviceRegId.equals("")) {
			// Automatically registers application on startup.
			GCMRegistrar.register(App42API.appContext, projectNo);

		} else {
			// App42Log.debug(" Registering on Server ....");

			App42API.buildPushNotificationService().storeDeviceToken(
					App42API.getLoggedInUser(), deviceRegId,
					new App42CallBack() {

						@Override
						public void onSuccess(Object paramObject) {
							// TODO Auto-generated method stub
							// App42Log.debug(" ..... Registeration Success ....");
							GCMRegistrar.setRegisteredOnServer(
									App42API.appContext, true);
						}

						@Override
						public void onException(Exception paramException) {
							// App42Log.debug(" ..... Registeration Failed ....");
							// App42Log.debug("storeDeviceToken :  Exception : on start up "
							// +paramException);

						}
					});

		}
	}

}
