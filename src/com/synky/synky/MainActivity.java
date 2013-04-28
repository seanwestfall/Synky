package com.synky.synky;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	Button profile, contacts, scan, preferences;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

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

		switch (v.getId()) {
		case R.id.btn_contacts:

			break;
		case R.id.btn_profile:

			break;
		case R.id.btn_scan:
			
			// TODO open the QR Code screen

			break;
		case R.id.btn_pref:

			break;

		default:
			break;
		}

	}

}
