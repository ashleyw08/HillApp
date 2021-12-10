package com.example.hill;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;


public class SelectIra extends AppCompatActivity {

    int iraFragmentStackLevel;
    Button searchButton1;
    FragmentTransaction selectIraFt;
    FragmentManager iraFm;
    TextView whichIsBestTxt;
    RadioButton rothRadioBtn, tradRadioBtn;
    Intent rIraWebIntent, tIraWebIntent;
    String rIraQuery = "https://google.com/search?q=open+roth+ira";
    String tIraQuery = "http://google.com/search?q=open+traditional+ira";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_ira);
        //find search button by ID
        searchButton1 = findViewById(R.id.nextBtnId1);
        //find radio button by ID
        rothRadioBtn = findViewById(R.id.rIRadioBtn);
        tradRadioBtn = findViewById(R.id.tIradioBtn);
        //
        whichIsBestTxt = findViewById(R.id.which_selectable_txt);
        //Set click listener for next button
        searchButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if (rothRadioBtn.isChecked())
                {
                    //error handing
                    try {
                        //start new intent for web search of Roth IRA search
                        rIraWebIntent = new Intent();
                        //set action of class Intent
                        rIraWebIntent.setAction(Intent.ACTION_VIEW);
                        //set the data aka URL
                        rIraWebIntent.setData(Uri.parse(rIraQuery));
                        //opens web
                        startActivity(rIraWebIntent);
                    } catch (ActivityNotFoundException exception) {
                        exception.printStackTrace();
                    }


                }
                if (tradRadioBtn.isChecked())
                {
                    //error handling
                    try {
                        //start new intent for web search of Traditional IRA search
                        tIraWebIntent = new Intent(Intent.ACTION_VIEW);
                        tIraWebIntent.setData(Uri.parse(tIraQuery));
                        //tIraWebIntent.putExtra(SearchManager.QUERY,tIraQuery);
                        startActivity(tIraWebIntent);
                    } catch (ActivityNotFoundException exception)
                    {
                        exception.printStackTrace();
                    }

                }
            }
        });
        //end if on click listener for radio buttons
        whichIsBestTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //try calling fragment
                try
                {
                    iraFragmentStackLevel++;
                    selectIraFt = getSupportFragmentManager().beginTransaction();
                    //find fragment
                    Fragment prev2 = getSupportFragmentManager().findFragmentByTag("Ira Info Dialog");

                    if (prev2 != null)
                    {
                        selectIraFt.remove(prev2);
                    }

                    selectIraFt.addToBackStack(null);
                    //new object of my custom dialog fragment class
                    IraInfoFragment iraDialog = IraInfoFragment.newInstance(iraFragmentStackLevel);
                    iraDialog.show(selectIraFt,"Ira Info Dialog");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        });


    }

}