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
import android.widget.TextView;

import com.rentmi.rentmi.R;

/**
 * The page will display your profile with a Image, Name, Bio & Distance.
 *
 * @author apill
 */

public class ProfileFragment extends Fragment {
    private final String FRAGMENT_TITLE = "My Profile";
    final static String TAG_1 = "FRAGMENT_1";
    final static String KEY_MSG_1 = "FRAGMENT1_MSG";
    private FragmentActivity myContext;

    //TextView for the Profile bio
    TextView textView;
    //Button to edit bio
    Button buttonbio;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment HomeFragment.
     */
    public static ProfileFragment newInstance()
    {
        return new ProfileFragment();
    }
    @Override
    public void onAttach(Activity activity)
    {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(FRAGMENT_TITLE);

        buttonbio = (Button) view.findViewById(R.id.editbio);
        buttonbio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction tx = myContext.getSupportFragmentManager().beginTransaction();
                tx.replace(R.id.content_frame, ProfileInfoFragment.newInstance());
                tx.commit();

            }
        });
        return view;
    }

    //use to uptade the new editted bio...yet to be done
    public void updateInfo(String bio)
    {

    }

}
