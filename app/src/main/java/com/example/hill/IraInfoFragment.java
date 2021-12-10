package com.example.hill;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class IraInfoFragment extends DialogFragment {

    View iraCloseBtn, iifView, iifTextView;
    FragmentTransaction iraInfoFt;

    public IraInfoFragment() {
        // Required empty public constructor
    }


    static IraInfoFragment newInstance(int num) {
        IraInfoFragment iif = new IraInfoFragment();
        Bundle args = new Bundle();
        args.putInt("nums", num);
        iif.setArguments(args);
        return iif;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        iifView = inflater.inflate(R.layout.fragment_ira_info, container, false);
        //find textview
        iifTextView = iifView.findViewById(R.id.iraInfoTextViewId);
        //cast view object to textview object to set text
        ((TextView) iifTextView).setText(R.string.whichIraPara);
        //find close button view to return to host activity
        iraCloseBtn = iifView.findViewById(R.id.iraInfoBtnId);

        iraCloseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //get fragment manager to do transaction
                iraInfoFt = getParentFragmentManager().beginTransaction();
                //remove this fragment view
                iraInfoFt.remove(IraInfoFragment.this);
                iraInfoFt.commit();
            }
        });
        // Inflate the layout for this fragment
        return iifView;
    }
}