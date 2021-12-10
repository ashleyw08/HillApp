package com.example.hill;


import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class HillInfoFragment extends DialogFragment {

    //declarations
    Intent selectIraIntent2;
    FragmentTransaction infoFt;

    public HillInfoFragment() {
        // Required empty public constructor
    }

    static HillInfoFragment newInstance(int num)
    {
        HillInfoFragment hf = new HillInfoFragment();

        Bundle args = new Bundle();
        //supply int num as argument
        args.putInt("num",num);
        hf.setArguments(args);
        return hf;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        //"hi" is the first to letters of the context being referenced. AKA Hill Info View.
        View hiView = inflater.inflate(R.layout.fragment_hill_info, container, false);
        //find textview of this dialog view
        View tv = hiView.findViewById(R.id.infoTextView);
        ((TextView)tv).setText(R.string.hill_descr);
        //find button(s) via view
        View cBtn = hiView.findViewById(R.id.infoCloseButton);
        View goBtn = hiView.findViewById(R.id.infoGoBtn);
        //set listener for close button
        cBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                FragmentTransaction infoFt = getFragmentManager().beginTransaction();
                //removing fragment object via "this"
                infoFt.remove(HillInfoFragment.this);
                infoFt.commit();
            }
        });
        //set listener for go button
        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                infoFt = getFragmentManager().beginTransaction();
                //Still need to remove fragment so user will be redirected to
                //previous activity screen and not the previous fragment
                infoFt.remove(HillInfoFragment.this);
                infoFt.commit();
                //Call new activity. Use getActivity since in a fragment. Need host's activity
                selectIraIntent2 = new Intent(getActivity(),SelectIra.class);
                startActivity(selectIraIntent2);
            }
        });
        // Inflate the layout for this fragment
        return hiView;
    }

}