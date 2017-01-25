package com.rentmi.rentmi.fragment;

import android.app.Activity;
import android.os.AsyncTask;
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
    String stringtext,stringtextname;

    //TextView for the Profile bio
    TextView textView;
    //Button to edit bio
    Button buttonbio;

    TextView textv,textn;


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

        textv = (TextView) view.findViewById(R.id.user_bio);
        textn= (TextView) view.findViewById(R.id.user_name);

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

    public void setText(String text)
    {
        textv.setText(text);

    }

    public void setName(String nametext)
    {

        textn.setText(nametext);
    }

    public void sentText()
    {
        new MyTask().execute();

    }

    private class MyTask extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            Bundle b= getArguments();
            stringtext = b.getString("text");
            //stringtextname = b.getString("nametext");
            return null;
        }
        public void onPostExecute(String result)
        {
            setText(stringtext);
            //setName(stringtextname);
        }

    }

    //use to uptade the new editted bio...yet to be done
    public void updateInfo(String bio)
    {

    }

}
