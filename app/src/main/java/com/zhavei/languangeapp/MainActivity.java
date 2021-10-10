package com.zhavei.languangeapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private boolean doubleBackPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        CategoryAdapter adapter = new CategoryAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs_on_activity_main);
        tabLayout.setupWithViewPager(viewPager);

//        // Set the content of the activity to use the activity_main.xml layout file
//        setContentView(R.layout.activity_main);
//
//        // Find the View that shows the numbers category
//        TextView numbers = (TextView) findViewById(R.id.numbers);
//
//        // Set a click listener on that View
//        numbers.setOnClickListener(new OnClickListener() {
//            // The code in this method will be executed when the numbers category is clicked on.
//            @Override
//            public void onClick(View view) {
//                // Create a new intent to open the {@link NumbersActivity}
//                Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);
//                // add toast message on click
//                Toast.makeText(view.getContext(), " Open List Of Numbers", Toast.LENGTH_SHORT).show();
//
//                // Start the new activity
//                startActivity(numbersIntent);
//            }
//        });
//
//        // Find the View that shows the family category
//        TextView family = (TextView) findViewById(R.id.family);
//
//        // Set a click listener on that View
//        family.setOnClickListener(new OnClickListener() {
//            // The code in this method will be executed when the family category is clicked on.
//            @Override
//            public void onClick(View view) {
//                // Create a new intent to open the {@link FamilyActivity}
//                Intent familyIntent = new Intent(MainActivity.this, FamilyActivity.class);
//                //add toast on click
//                Toast.makeText(view.getContext(), "Open Family List", Toast.LENGTH_SHORT).show();
//                // Start the new activity
//                startActivity(familyIntent);
//            }
//        });
//
//        // Find the View that shows the colors category
//        TextView colors = (TextView) findViewById(R.id.colors);
//
//        // Set a click listener on that View
//        colors.setOnClickListener(new OnClickListener() {
//            // The code in this method will be executed when the colors category is clicked on.
//            @Override
//            public void onClick(View view) {
//                // Create a new intent to open the {@link ColorsActivity}
//                Intent colorsIntent = new Intent(MainActivity.this, ColorsActivity.class);
//                //add toast on click
//                Toast.makeText(view.getContext(), " open colors list", Toast.LENGTH_SHORT).show();
//                // Start the new activity
//                startActivity(colorsIntent);
//            }
//        });
//
//        // Find the View that shows the phrases category
//        TextView phrases = (TextView) findViewById(R.id.phrases);
//
//        // Set a click listener on that View
//        phrases.setOnClickListener(new OnClickListener() {
//            // The code in this method will be executed when the phrases category is clicked on.
//            @Override
//            public void onClick(View view) {
//                // Create a new intent to open the {@link PhrasesActivity}
//                Intent phrasesIntent = new Intent(MainActivity.this, PhrasesActivity.class);
//                //add toast on click
//                Toast.makeText(view.getContext(), "open list phrases", Toast.LENGTH_SHORT).show();
//                // Start the new activity
//                startActivity(phrasesIntent);
//            }
//        });
    }

    @Override
    public void onBackPressed(){
        if (doubleBackPressedOnce){
            super.onBackPressed();
            return;
        }

        this.doubleBackPressedOnce = true;
        Toast.makeText(this, "press again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackPressedOnce=false;
            }
        }, 2000);

    }
}