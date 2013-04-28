package com.synky.synky;

import com.navdrawer.SimpleSideDrawer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	Button profile, contacts, scan, preferences;
	static String contents;
	SimpleSideDrawer mSlidingMenu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		mSlidingMenu = new SimpleSideDrawer( this );
	    mSlidingMenu.setLeftBehindContentView( R.layout.behind_menu_left );

		initViews();
		
		profile.setOnClickListener(this);
		contacts.setOnClickListener(this);
		scan.setOnClickListener(this);
		preferences.setOnClickListener(this);

	}

	private void initViews() {

		profile = (Button) findViewById(R.id.btn_profile);
		contacts = (Button) findViewById(R.id.btn_contacts);
		scan = (Button) findViewById(R.id.btn_scan);
		preferences = (Button) findViewById(R.id.btn_pref);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {

		Intent intent;

		switch (v.getId()) {
		case R.id.btn_contacts:
			intent = new Intent(getApplicationContext(), SynkyContacts.class);
			MainActivity.this.startActivity(intent);

			break;
		case R.id.btn_profile:
			intent = new Intent(getApplicationContext(), SynkyProfile.class);
			MainActivity.this.startActivity(intent);

			break;
		case R.id.btn_scan:

			Intent scanIntent = new Intent(
					"com.google.zxing.client.android.SCAN");
			scanIntent.putExtra("SCAN_MODE", "QR_CODE_MODE");
			startActivityForResult(scanIntent, 0);

			break;
		case R.id.btn_pref:
			intent = new Intent(getApplicationContext(), SynkyPreferences.class);
			MainActivity.this.startActivity(intent);

			break;

		default:
			break;
		}

	}

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		if (requestCode == 0) {
			if (resultCode == RESULT_OK) {
				contents = intent.getStringExtra("SCAN_RESULT");
				String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
				Log.i("Barcode Result", contents);
				Intent i1 = new Intent(MainActivity.this,
						SynkyScan.class);
				startActivity(i1);		
				// Handle successful scan
			} else if (resultCode == RESULT_CANCELED) {
				// Handle cancel
				Log.i("Barcode Result", "Result canceled");
			}
		}
	}
}
