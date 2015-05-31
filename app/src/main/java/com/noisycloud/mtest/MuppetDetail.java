package com.noisycloud.mtest;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

public class MuppetDetail extends AppCompatActivity {

	public static final String EXTRA_MUPPET_NAME = "extra_muppet_name";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);

		Intent intent = getIntent();
		final String muppetName = intent.getStringExtra(EXTRA_MUPPET_NAME);

		final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
		imageView.setBackground(getImage(muppetName));

		final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
		collapsingToolbar.setTitle(muppetName);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				finish();
				return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private Drawable getImage(String muppetName){
		switch(muppetName){
			case "Fuzzy":
				return getResources().getDrawable(R.drawable.fuzzy);
			case "Gonzo":
				return getResources().getDrawable(R.drawable.gonzo1);
			case "Animal":
				return getResources().getDrawable(R.drawable.animal);
			case "Kermit":
				return getResources().getDrawable(R.drawable.kermit);
			case "Sam The Eagle":
				return getResources().getDrawable(R.drawable.sam);
			default:
				return getResources().getDrawable(R.drawable.gonzo1);
		}
	}
}