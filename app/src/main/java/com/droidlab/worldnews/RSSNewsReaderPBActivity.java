package com.droidlab.worldnews;

import android.app.AlertDialog;
import android.app.TabActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.TabHost.TabSpec;

public class RSSNewsReaderPBActivity extends TabActivity {
	TabHost tabhost;
	Intent intent;
	TabSpec spec;
	int currentTab;
	String CURRENT_TAB;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.main);

		tabhost = getTabHost();

		Intent intentIndia = new Intent().setClass(this, India_News.class);
		TabSpec indiaSpec = tabhost
				.newTabSpec("India")
				.setIndicator("India",
						getResources().getDrawable(R.drawable.draft))
				.setContent(intentIndia);
		tabhost.addTab(indiaSpec);

		Intent intentWorld = new Intent().setClass(this, World_News.class);
		TabSpec worldSpec = tabhost
				.newTabSpec("World")
				.setIndicator("World",
						getResources().getDrawable(R.drawable.draft))
				.setContent(intentWorld);
		tabhost.addTab(worldSpec);

		Intent intentFav = new Intent().setClass(this, Favourites_News.class);
		TabSpec favSpec = tabhost
				.newTabSpec("Cricket")
				.setIndicator("Cricket",
						getResources().getDrawable(R.drawable.cricket))
				.setContent(intentFav);
		tabhost.addTab(favSpec);

		Intent intentRSS = new Intent().setClass(this, RSS_News.class);
		TabSpec rssSpec = tabhost
				.newTabSpec("All Sports")
				.setIndicator("All Sports",
						getResources().getDrawable(R.drawable.all))
				.setContent(intentRSS);
		tabhost.addTab(rssSpec);

		System.gc();


	//	tabhost.getTabWidget().getChildAt(0).setBackgroundResource(R.drawable.tab1selector);
	//	tabhost.getTabWidget().getChildAt(0).settBackgroundResource(R.drawable.tab1selector);
	}
	
	/*protected void onSaveInstanceState(Bundle outState) {   
	    
	    saveState();
	    outState.putInt(CURRENT_TAB, getTabHost().getCurrentTab());
	    super.onSaveInstanceState(outState);	}

	protected void onRestoreInstanceState(Bundle savedInstanceState){
	    currentTab = (savedInstanceState ==null) ? currentTab=0 :
	           savedInstanceState.getInt(CURRENT_TAB);
	    if(currentTab >=0){
	        getTabHost().setCurrentTab(currentTab);
	    }
	}
	protected void onPause() {
	    super.onPause();    
	    saveState();
	}
	protected void onResume() {
	    super.onResume();   
	    getTabHost().setCurrentTab(currentTab);     
	}   
	private void saveState(){
	    currentTab=getTabHost().getCurrentTab();
	}*/

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater mInflater = getMenuInflater();
		mInflater.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent;

		switch (item.getItemId()) {
		case R.id.menuAdd: {
			intent = new Intent(this, AddNewFeed.class);
			startActivity(intent);
			break;
		}
		case R.id.menuAboutMe: {
			AlertDialog alertDialog = new AlertDialog.Builder(this).create();
			alertDialog.setTitle("About");
			alertDialog.setMessage("Droidlab");
			alertDialog.setIcon(R.drawable.info);
			alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
				}
			});

			alertDialog.show();
			break;
		}
		case R.id.menuQuit: {
			AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
			alertDialog.setTitle("Exit");
			alertDialog.setMessage("Do you want to Exit ?");
			alertDialog.setCancelable(false);
			alertDialog.setIcon(R.drawable.close);
			alertDialog.setPositiveButton("Yes",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialoginterface,
								int i) {
							finish();
						}
					});
			alertDialog.setNegativeButton("No",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialoginterface,
								int i) {
							dialoginterface.cancel();
						}
					});
			AlertDialog alert = alertDialog.create();
			alert.show();
		}
		default:
			Toast.makeText(this, "Thanks", Toast.LENGTH_LONG).show();
			break;
		}
		return true;
	}

	@Override
	public void onBackPressed() {
		finish();
	}
}