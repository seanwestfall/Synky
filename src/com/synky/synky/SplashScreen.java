package com.synky.synky;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class SplashScreen extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.splash);
		
		
		IntentLuancher launcher = new IntentLuancher();
		launcher.start();
	}
	
	private class IntentLuancher extends Thread{
		
		public void run(){
			try{
				Thread.sleep(2000);
			}catch (Exception e) {
				
			}
			
			Intent intent = new Intent(getApplicationContext(), MainActivity.class);
			SplashScreen.this.startActivity(intent);
			SplashScreen.this.finish();
			
			}
		
	}

}
