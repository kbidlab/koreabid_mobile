package kr.co.koreabid.koreabidapp;

import android.os.Bundle;
import org.apache.cordova.*;

public class PhoneGapActivity extends DroidGap{
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		//super.setIntegerProperty("backgroundColor", Color.rgb(239, 239, 239));
		//super.setIntegerProperty("splashscreen", R.drawable.intro);
		//super.setStringProperty("loadingDialog", "Loading...");
		
		super.setIntegerProperty("splashscreen", R.drawable.intro);
		super.loadUrl("file:///android_asset/www/index.html", 4000);
		
		// Initialize activity
		//super.init();
		
		//super.appView.setBackgroundColor(0);
		//super.appView.setBackgroundResource(R.drawable.splash);
		
		// Clear cache if you want
		//super.appView.clearCache(true);
		
		
		//super.loadUrl("file:///android_asset/www/index.html");
		//super.setIntegerProperty("loadUrlTimeoutValue", 60000);
	}
}