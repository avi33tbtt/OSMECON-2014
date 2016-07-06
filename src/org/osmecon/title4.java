package org.osmecon;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.view.View.*;
import android.view.animation.*;

public class title4 extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.title4);
		final Button b = (Button) findViewById(R.id.a4);
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Animation anim = AnimationUtils.loadAnimation(title4.this,
						R.anim.animate);
				b.startAnimation(anim);
			}
		});

	}
}
