package com.example.hill;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    //declarations
    private Button startBtn;
    private TextView infoSelectTxt;
    private FragmentManager mainFm;
    private FragmentTransaction mainFt;
    private Intent selectIraIntent;
    private int fragmentStackLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //find Button(s)
        startBtn = findViewById(R.id.start_button);
        infoSelectTxt = findViewById(R.id.info_selectable_txt);

        infoSelectTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInfoDialog();
            }
        });

        //Called when user wants to begin searching
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //error handling
                try {
                    selectIraIntent = new Intent(getBaseContext(),SelectIra.class);
                    startActivity(selectIraIntent);
                } catch (Exception e) {
                    e.printStackTrace();

                }

            }
        });

        //Called when user wants the 411
        /*infoSelectTxt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                showInfoDialog();
                return true;
            }
        });
*/
    }

    private void showInfoDialog()
    {
        fragmentStackLevel++;
        //get manager to start transaction
        mainFt = getFragmentManager().beginTransaction();
        //find fragment
        Fragment prev = getFragmentManager().findFragmentByTag("Info Dialog");
        //remove currently shown fragment before displaying another.
        if (prev != null)
        {
          mainFt.remove(prev);

        }
        //remembering transaction after committing
        //action will be reversed when popped from stack
        mainFt.addToBackStack(null);
        //create obj of my customized dialog class and
        //call the function provided in the custom class.
        HillInfoFragment d1 = HillInfoFragment.newInstance(fragmentStackLevel);
        d1.show(mainFt,"Info Dialog");

    }

}