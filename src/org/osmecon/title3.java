package org.osmecon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ProgressBar;

public class title3 extends Activity {
	ProgressBar loadingProgressBar, loadingTitle;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.title3);
		final Button b = (Button) findViewById(R.id.a3);
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Animation anim = AnimationUtils.loadAnimation(title3.this,
						R.anim.animate);
				b.startAnimation(anim);
			}
		});

		final Button t1 = (Button) findViewById(R.id.ast);
		t1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent1 = new Intent(title3.this, registerpage.class);
				startActivity(intent1);
				overridePendingTransition(R.anim.slidein, R.anim.slideout);

			}
		});

	}
}