package com.rentmi.rentmi.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rentmi.rentmi.R;

/**
 * Yet to be made.
 *
 * @author apill
 */

public class RevenueHubFragment extends Fragment
{
    private final String FRAGMENT_TITLE = "Revenue Hub";

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment HomeFragment.
     */
    public static RevenueHubFragment newInstance()
    {

        return new RevenueHubFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_revenue_hub, container, false);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(FRAGMENT_TITLE);

        return view;
    }

}
