package com.noisycloud.mtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		//Create list of rugby players
		ArrayList<String> players = new ArrayList<String>();
		players.add("Kermit");
		players.add("Animal");
		players.add("Gonzo");
		players.add("Kermit");
		players.add("Animal");
		players.add("Gonzo");
		players.add("Kermit");
		players.add("Animal");
		players.add("Gonzo");
		players.add("Fuzzy");
		players.add("Sam The Eagle");

		RecyclerView recyclerView = (RecyclerView) findViewById(R.id.activity_main_listview);

		recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
		recyclerView.setAdapter(new MyRecyclerView(this, players));
	}
}