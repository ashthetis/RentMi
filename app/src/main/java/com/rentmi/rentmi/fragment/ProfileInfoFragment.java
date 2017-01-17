package com.rentmi.rentmi.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.rentmi.rentmi.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * to handle interaction events.
 * Use the {@link ProfileInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileInfoFragment extends Fragment {
    private final String FRAGMENT_TITLE = "Profile Information";
    private FragmentActivity myContext;

    //Edited bio
    EditText m_et;

    //Button to submit the edited bio
    Button m_btn;

    //Variabe to setText of the bio
    //Yet to be Implemented
    TextView textViewbio;


    @Override
    public void onAttach(Activity activity)
    {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

    public static ProfileInfoFragment newInstance()
    {
        return new ProfileInfoFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_profile_info, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(FRAGMENT_TITLE);

        //variables
        m_btn = (Button) view.findViewById((R.id.submit));
        m_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                FragmentTransaction tx = myContext.getSupportFragmentManager().beginTransaction();
                tx.replace(R.id.content_frame, ProfileFragment.newInstance());
                tx.commit();
            }
        });
        return view;
    }
}
