package org.osmecon;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.shephertz.app42.paas.sdk.android.App42API;

public class MainActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		final Button b = (Button) findViewById(R.id.t);
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Animation anim = AnimationUtils.loadAnimation(
						MainActivity.this, R.anim.animate);
				b.startAnimation(anim);
			}
		});

		final Button t1 = (Button) findViewById(R.id.title1);
		t1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent1 = new Intent(MainActivity.this, title1.class);
				startActivity(intent1);
				overridePendingTransition(R.anim.slidein, R.anim.slideout);
			}
		});

		final Button t2 = (Button) findViewById(R.id.title2);
		t2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent2 = new Intent(MainActivity.this, title2.class);
				startActivity(intent2);
				overridePendingTransition(R.anim.slidein, R.anim.slideout);

			}
		});

		final Button acc = (Button) findViewById(R.id.accb);
		acc.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent3a = new Intent(MainActivity.this, accom.class);
				startActivity(intent3a);
				overridePendingTransition(R.anim.slidein, R.anim.slideout);

			}
		});

		
		final Button t3 = (Button) findViewById(R.id.title3);
		t3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent3 = new Intent(MainActivity.this, title3.class);
				startActivity(intent3);
				overridePendingTransition(R.anim.slidein, R.anim.slideout);

			}
		});

		final Button t4 = (Button) findViewById(R.id.title4);
		t4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent4 = new Intent(MainActivity.this, title4.class);
				startActivity(intent4);
				overridePendingTransition(R.anim.slidein, R.anim.slideout);

			}
		});
		
		final Button tt4 = (Button) findViewById(R.id.pay);
		tt4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intents4 = new Intent(MainActivity.this, payment.class);
				startActivity(intents4);
				overridePendingTransition(R.anim.slidein, R.anim.slideout);

			}
		});
		
		final Button t4a = (Button) findViewById(R.id.titlewa);
		t4a.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent4a = new Intent(MainActivity.this, schedule.class);
				startActivity(intent4a);
				overridePendingTransition(R.anim.slidein, R.anim.slideout);

			}
		});
		
		final Button t4aa = (Button) findViewById(R.id.cguestb);
		t4aa.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent4aa = new Intent(MainActivity.this, cguest.class);
				startActivity(intent4aa);
				overridePendingTransition(R.anim.slidein, R.anim.slideout);

			}
		});

		final Button t5 = (Button) findViewById(R.id.title5);
		t5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent5 = new Intent(MainActivity.this, title5.class);
				startActivity(intent5);
				overridePendingTransition(R.anim.slidein, R.anim.slideout);

			}
		});

		final Button t6 = (Button) findViewById(R.id.abutton);
		t6.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent6 = new Intent(MainActivity.this,
						announcements.class);
				startActivity(intent6);
				overridePendingTransition(R.anim.slidein, R.anim.slideout);

			}
		});

		final Button team = (Button) findViewById(R.id.team);
		team.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intentteam = new Intent(MainActivity.this, team.class);
				startActivity(intentteam);

			}
		});

		App42API.initialize(
				this,
				"e47e34f216e197a7af1390242555736d10c7e6d3e8a3817641d32ee211a9dfe9",
				"bb096be90c2937eb949c877b3d0eee37e1ec1b67a45b2593aaf304978ecc85bb");
		App42API.setLoggedInUser("osmecon.push@gmail.com");
		Util.registerWithApp42("122629890352");

	}

	/*
	 * * This method is called when a Activty is stop disable all the events if
	 * occuring (non-Javadoc)
	 * 
	 * @see android.app.Activity#onStop()
	 */
	public void onStop() {
		super.onStop();

	}

	/*
	 * This method is called when a Activty is finished or user press the back
	 * button (non-Javadoc)
	 * 
	 * @override method of superclass
	 * 
	 * @see android.app.Activity#onDestroy()
	 */
	public void onDestroy() {
		super.onDestroy();
		unregisterReceiver(mBroadcastReceiver);
	}

	/*
	 * called when this activity is restart again
	 * 
	 * @override method of superclass
	 */
	public void onReStart() {
		super.onRestart();
	}

	/*
	 * called when activity is paused
	 * 
	 * @override method of superclass (non-Javadoc)
	 * 
	 * @see android.app.Activity#onPause()
	 */
	public void onPause() {
		super.onPause();
	}

	/*
	 * called when activity is resume
	 * 
	 * @override method of superclass (non-Javadoc)un
	 * 
	 * @see android.app.Activity#onResume()
	 */
	public void onResume() {
		super.onResume();
		String message = getIntent().getStringExtra(
				App42GCMService.EXTRA_MESSAGE);

		IntentFilter filter = new IntentFilter(
				App42GCMService.DISPLAY_MESSAGE_ACTION);
		filter.setPriority(2);
		registerReceiver(mBroadcastReceiver, filter);
	}

	final BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {

			String message = intent
					.getStringExtra(App42GCMService.EXTRA_MESSAGE);
			((TextView) findViewById(R.id.text)).setText(message);

		}
	};
}