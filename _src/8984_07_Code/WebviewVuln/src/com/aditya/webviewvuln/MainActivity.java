package com.aditya.webviewvuln;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends Activity {

	@SuppressLint({ "SetJavaScriptEnabled", "JavascriptInterface" })
	 @Override
	        protected void onCreate(Bundle savedInstanceState) {

//The code has been taken from Jduck's github repo : https://github.com/jduck/VulnWebView/
	                super.onCreate(savedInstanceState);
	                setContentView(R.layout.activity_main);
	                
	                final Button button = (Button) findViewById(R.id.button1);
	        button.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	                // Perform action on click
	                        WebView myWebView = (WebView) findViewById(R.id.webView1);
	                        myWebView.reload();
	            } });
	                
	                WebView myWebView = (WebView) findViewById(R.id.webView1);
	                
	                // not a good idea!
	                WebSettings webSettings = myWebView.getSettings();
	                webSettings.setJavaScriptEnabled(true);
	                
	                // terrible idea!
	                myWebView.addJavascriptInterface(new WebAppInterface(this), "Android");
	                
	                // woot.
	                myWebView.loadUrl("http://droidsec.org/addjsif.html");
	        }

	        @Override
	        public boolean onCreateOptionsMenu(Menu menu) {
	                // Inflate the menu; this adds items to the action bar if it is present.
	                getMenuInflater().inflate(R.menu.main, menu);
	                return true;
	        }}

	