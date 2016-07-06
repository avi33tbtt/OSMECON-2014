package org.osmecon;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class schedule extends Activity {

	final String conDate = "2014/09/04" ;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.schedule);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date dt = null;
		try {
			dt = sdf.parse(conDate);
		}
		catch(final java.text.ParseException e){
			e.printStackTrace();
		}
		
		final Calendar BDay = Calendar.getInstance();
		BDay.setTime(dt);
		
		final Calendar today = Calendar.getInstance();
		TextView swt = (TextView) findViewById(R.id.count);
		//Result in milis
		final long milis = BDay.getTimeInMillis() - today.getTimeInMillis();
		if ( BDay.getTimeInMillis() >= today.getTimeInMillis() ){
		//convert to days
		final long days = milis / 86400000; // 24*60*60*1000
		
		final long allhours = milis / 3600000; // 60*60*1000
		final long hours = allhours - (days * 24);
		
		sdf = new SimpleDateFormat("EEEE");
		sdf.format(dt);
		
		String tdays = String.valueOf(days);
		String thours = String.valueOf(hours);
		
		String tout =  tdays + " Days" + " and " + thours +" hours.";  
		
		swt.setText(tout);
		} else {
			swt.setText("Welcome to OSMECON 2014.");
		}
		
		final Button b = (Button) findViewById(R.id.sd);
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Animation anim = AnimationUtils.loadAnimation(schedule.this,
						R.anim.animate);
				b.startAnimation(anim);
			}
		});

	}
}