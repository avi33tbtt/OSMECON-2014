package org.osmecon;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class payment extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.payment);

		final Button b = (Button) findViewById(R.id.ap);
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Animation anim = AnimationUtils.loadAnimation(payment.this,
						R.anim.animate);
				b.startAnimation(anim);
			}
		});

	}
}