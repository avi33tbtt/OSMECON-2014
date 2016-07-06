package org.osmecon;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.view.View.*;
import android.view.animation.*;
import android.content.*;

public class title2 extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.title2);

		final Button ba = (Button) findViewById(R.id.a2);
		ba.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Animation anim = AnimationUtils.loadAnimation(title2.this,
						R.anim.animate);
				ba.startAnimation(anim);
			}
		});

		final Button a = (Button) findViewById(R.id.a);
		a.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent1 = new Intent(title2.this, a.class);
				startActivity(intent1);
				overridePendingTransition(R.anim.slidein, R.anim.slideout);

			}
		});

		final Button b = (Button) findViewById(R.id.b);
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent1 = new Intent(title2.this, b.class);
				startActivity(intent1);
				overridePendingTransition(R.anim.slidein, R.anim.slideout);

			}
		});

		final Button c = (Button) findViewById(R.id.c);
		c.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent1 = new Intent(title2.this, c.class);
				startActivity(intent1);
				overridePendingTransition(R.anim.slidein, R.anim.slideout);

			}
		});

		final Button d = (Button) findViewById(R.id.d);
		d.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent1 = new Intent(title2.this, d.class);
				startActivity(intent1);
				overridePendingTransition(R.anim.slidein, R.anim.slideout);

			}
		});

		final Button e = (Button) findViewById(R.id.e);
		e.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent1 = new Intent(title2.this, e.class);
				startActivity(intent1);
				overridePendingTransition(R.anim.slidein, R.anim.slideout);

			}
		});

		final Button f = (Button) findViewById(R.id.f);
		f.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent1 = new Intent(title2.this, f.class);
				startActivity(intent1);
				overridePendingTransition(R.anim.slidein, R.anim.slideout);

			}
		});

		final Button g = (Button) findViewById(R.id.g);
		g.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent1 = new Intent(title2.this, g.class);
				startActivity(intent1);
				overridePendingTransition(R.anim.slidein, R.anim.slideout);

			}
		});

		final Button h = (Button) findViewById(R.id.h);
		h.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent1 = new Intent(title2.this, h.class);
				startActivity(intent1);
				overridePendingTransition(R.anim.slidein, R.anim.slideout);

			}
		});

	}
}