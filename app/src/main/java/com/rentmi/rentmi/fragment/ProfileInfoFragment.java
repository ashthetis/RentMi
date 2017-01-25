package com.rentmi.rentmi.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
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
    OnFrgamentSendText mSendText;
    private final String FRAGMENT_TITLE = "Profile Information";
    private FragmentActivity myContext;

    //Edited bio
    String send_text,send_name;
    EditText text;
    EditText nametext;

    //Button to submit the edited bio
    Button m_btn;

    //Variabe to setText of the bio
    //Yet to be Implemented
    TextView textViewbio;
public interface OnFrgamentSendText
{
    //Method to recieve the text inside the activity
    public void onSentText(String text);
  //  public void onSentName(String nametext);

}

    //Make sure the activity has the interface implemented in it.
    @Override
    public void onAttach(Activity activity)
    {
       // myContext=(FragmentActivity) activity;
        super.onAttach(activity);
        try {
            mSendText= (OnFrgamentSendText)activity;
        }catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString() + " must implement OnFragmentSendText");
        }
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
        text = (EditText) view.findViewById(R.id.et1);
        nametext = (EditText) view.findViewById(R.id.et2);
        m_btn = (Button) view.findViewById((R.id.submit));
        m_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                send_text= text.getText().toString();
                send_name=nametext.getText().toString();
                mSendText.onSentText(send_text);
              //  mSendText.onSentName(send_name);

            }
        });
        return view;
    }
}
