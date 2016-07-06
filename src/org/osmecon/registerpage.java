package org.osmecon;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;

public class registerpage extends Activity {

	ProgressBar loadingProgressBar, loadingTitle;
	private WebView webView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registerpage);
		// getWindow().requestFeature(Window.FEATURE_PROGRESS);

		final Button b = (Button) findViewById(R.id.ar);
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Animation anim = AnimationUtils.loadAnimation(
						registerpage.this, R.anim.animate);
				b.startAnimation(anim);
			}
		});

		webView = (WebView) findViewById(R.id.webr);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.setWebViewClient(new WebViewClient());
		webView.loadUrl("http://www.osmecon.org/registration-form/");

		loadingProgressBar = (ProgressBar) findViewById(R.id.progressbar_Horizontal9);

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