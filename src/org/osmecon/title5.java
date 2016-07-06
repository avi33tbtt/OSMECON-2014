package org.osmecon;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;

public class title5 extends Activity {

	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.title5);
		// getWindow().requestFeature(Window.FEATURE_PROGRESS);

		final Button b = (Button) findViewById(R.id.a5);
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Animation anim = AnimationUtils.loadAnimation(title5.this,
						R.anim.animate);
				b.startAnimation(anim);
			}
		});

	}
}