package com.example.mycontactlist;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class ContactSettingsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_settings);
		
		initSettings();
		initSortByClick();
		initSortOrderClick();
		initListButton();
		initMapButton();
		initSettingsButton();
		initChooseColorClick();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.contact_settings, menu);
		return true;
	}

	private void initSettings() {
		String sortBy = getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE).getString("sortfield", "contactname");
		String sortOrder = getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE).getString("sortorder", "ASC");
		String chooseColor = getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE).getString("choosecolor", "Lavender");

		RadioButton rbName = (RadioButton) findViewById(R.id.radioName);
		RadioButton rbCity = (RadioButton) findViewById(R.id.radioCity);
		RadioButton rbBirthDay = (RadioButton) findViewById(R.id.radioBirthday);
		if (sortBy.equalsIgnoreCase("contactname")) {
			rbName.setChecked(true);
		}
		else if (sortBy.equalsIgnoreCase("city")) {
			rbCity.setChecked(true);
		}
		else {
			rbBirthDay.setChecked(true);
		}			

		RadioButton rbAscending = (RadioButton) findViewById(R.id.radioAscending);
		RadioButton rbDescending = (RadioButton) findViewById(R.id.radioDescending);
		if (sortOrder.equalsIgnoreCase("ASC")) {
			rbAscending.setChecked(true);
		}
		else {
			rbDescending.setChecked(true);
		}
		
		ScrollView s = (ScrollView) findViewById(R.id.scrollView1);
		
		
		RadioButton rbOrange = (RadioButton) findViewById(R.id.radio_orange);
		RadioButton rbGreen = (RadioButton) findViewById(R.id.radio_green);
		RadioButton rbPurple = (RadioButton) findViewById(R.id.radio_purple);
		if (chooseColor.equalsIgnoreCase("Orange")) {
			rbOrange.setChecked(true);
			s.setBackgroundResource(R.color.radio_orange);
		}
		else if (chooseColor.equalsIgnoreCase("Green")){
			rbGreen.setChecked(true);
			s.setBackgroundResource(R.color.radio_green);
		}
		else {
			rbPurple.setChecked(true);
			s.setBackgroundResource(R.color.system_white);
		}
	}
	
	private void initSortByClick() {
		RadioGroup rgSortBy = (RadioGroup) findViewById(R.id.radioGroup1);
		rgSortBy.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				RadioButton rbName = (RadioButton) findViewById(R.id.radioName);
				RadioButton rbCity = (RadioButton) findViewById(R.id.radioCity);
				if (rbName.isChecked()) {
					getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE).edit().putString("sortfield", "contactname").commit();
				}
				else if (rbCity.isChecked()) {
					getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE).edit().putString("sortfield", "city").commit();
				}
				else {
					getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE).edit().putString("sortfield", "birthday").commit();
				}			
			}		
		});
	}

	private void initSortOrderClick() {
		RadioGroup rgSortOrder = (RadioGroup) findViewById(R.id.radioGroup2);
		rgSortOrder.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				RadioButton rbAscending = (RadioButton) findViewById(R.id.radioAscending);
				if (rbAscending.isChecked()) {
					getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE).edit().putString("sortorder", "ASC").commit();
				}
				else {
					getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE).edit().putString("sortorder", "DESC").commit();
				}			
			}		
		});
	}
	
	private void initChooseColorClick() {
		RadioGroup rgChooseColor = (RadioGroup) findViewById(R.id.radioGroup3);
		rgChooseColor.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				RadioButton rbOrange = (RadioButton) findViewById(R.id.radio_orange);
				RadioButton rbGreen = (RadioButton) findViewById(R.id.radio_green);
				if (rbOrange.isChecked()) {
					getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE).edit().putString("choosecolor", "Lavender").commit();
				}
				else if (rbGreen.isChecked()){
					getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE).edit().putString("choosecolor", "LightGrey").commit();
				}
				else {
					getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE).edit().putString("choosecolor", "LightGreen").commit();
				}
			}		
		});
	}

	private void initListButton() {
        ImageButton list = (ImageButton) findViewById(R.id.imageButtonList);
        list.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
    			Intent intent = new Intent(ContactSettingsActivity.this, ContactListActivity.class);
    			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    			startActivity(intent);
            }
        });
	}

	private void initSettingsButton() {
        ImageButton list = (ImageButton) findViewById(R.id.imageButtonSettings);
        list.setEnabled(false);
	}

	private void initMapButton() {
        ImageButton list = (ImageButton) findViewById(R.id.imageButtonMap);
        list.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
        		Intent intent = new Intent(ContactSettingsActivity.this, ContactMapActivity.class);
    			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		   		startActivity(intent);
            }
        });
	}
	
}
