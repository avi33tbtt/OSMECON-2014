package org.osmecon;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;

public class announcements extends Activity {
	private WebView webView;
	ProgressBar loadingProgressBar, loadingTitle;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.announcements);
		// getWindow().requestFeature(Window.FEATURE_PROGRESS);

		final Button b = (Button) findViewById(R.id.a8);
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Animation anim = AnimationUtils.loadAnimation(
						announcements.this, R.anim.animate);
				b.startAnimation(anim);
			}
		});

		webView = (WebView) findViewById(R.id.weba);
		webView.getSettings().setJavaScriptEnabled(false);
		webView.setWebViewClient(new WebViewClient());
		webView.loadUrl("http://osmecon1.appspot.com/cont");

		loadingProgressBar = (ProgressBar) findViewById(R.id.progressbar_Horizontal8);
		webView.setWebChromeClient(new WebChromeClient() {
			// this will be called on page loading progress
			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				super.onProgressChanged(view, newProgress);
				loadingProgressBar.setProgress(newProgress);
				// loadingTitle.setProgress(newProgress);
				// hide the progress bar if the loading is complete
				if (newProgress == 100) {
					loadingProgressBar.setVisibility(View.GONE);
				} else {
					loadingProgressBar.setVisibility(View.VISIBLE);
				}
			}
		});
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
			webView.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}