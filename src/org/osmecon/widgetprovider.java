package org.osmecon;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;
import android.widget.TextView;

public class widgetprovider extends AppWidgetProvider {
	
	final String conDate = "2014/09/04" ;
	
	@Override
	public void onUpdate (Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		
		//initializing widget layout		
		
		//updating view with initial data
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
		
	//	TextView swt = (TextView) findViewById(R.id.countw);
		
		if ( BDay.getTimeInMillis() <= today.getTimeInMillis() ){
		//Result in milis
		final long milis = BDay.getTimeInMillis() - today.getTimeInMillis();
		
		//convert to days
		final long days = milis / 86400000; // 24*60*60*1000
		
		final long allhours = milis / 3600000; // 60*60*1000
		final long hours = allhours - (days * 24);
		
		sdf = new SimpleDateFormat("EEEE");
		sdf.format(dt);
		
		String tdays = String.valueOf(days);
		String thours = String.valueOf(hours);
		
		String tout =  tdays + " Days" + " and " + thours +" hours.";  
		
	//		swt.setText(tout);
		} else {
	//		swt.setText("Welcome to OSMECON 2014.");
		}

		// request for widget update
	//	pushWidgetUpdate(context, remoteViews ); }
	
	
	}
}
