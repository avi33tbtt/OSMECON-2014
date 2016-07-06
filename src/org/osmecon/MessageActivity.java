/**
 * 
 */
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

public class MessageActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final Button bn = (Button) findViewById(R.id.tn);
		bn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Animation anim = AnimationUtils.loadAnimation(
						MessageActivity.this, R.anim.animate);
				bn.startAnimation(anim);
			}
		});

		final Button tba = (Button) findViewById(R.id.butto);
		tba.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent3 = new Intent(MessageActivity.this,
						MainActivity.class);
				startActivity(intent3);

			}
		});

		final Button tbao = (Button) findViewById(R.id.buttoa);
		tbao.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent4 = new Intent(MessageActivity.this,
						announcements.class);
				startActivity(intent4);

			}
		});

		String message = getIntent().getStringExtra(
				App42GCMService.EXTRA_MESSAGE);
		App42GCMService.resetMsgCount();
		((TextView) findViewById(R.id.text)).setText(message);

	}

	public void onClick(View view) {
		finish();
	}

	public void onResume() {
		super.onResume();
		String message = getIntent().getStringExtra(
				App42GCMService.EXTRA_MESSAGE);

		IntentFilter filter = new IntentFilter(
				App42GCMService.DISPLAY_MESSAGE_ACTION);
		filter.setPriority(2);
		registerReceiver(mBroadcastReceiver, filter);
	}

	@Override
	public void onPause() {
		unregisterReceiver(mBroadcastReceiver);
		super.onPause();
	}

	final BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {

			// Right here do what you want in your activity
			String message = intent
					.getStringExtra(App42GCMService.EXTRA_MESSAGE);

			((TextView) findViewById(R.id.text)).setText(message);
			App42GCMService.resetMsgCount();

		}
	};

}
