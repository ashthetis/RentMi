package com.rentmi.rentmi.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.rentmi.rentmi.R;
import java.util.ArrayList;
import Adapter.ContactsAdapter;
import Model.Contact;

/**
 * The page will display all the listed details and the areas.
 *
 * @author apill
 */

public class ListingsFragment extends Fragment
{
    private RecyclerView mRecyclerView;

    private RecyclerView.Adapter mAdapter;

    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Contact> contacts;
    private final String FRAGMENT_TITLE = "Listings";
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment HomeFragment.
         */
        public static ListingsFragment newInstance()
        {

            return new ListingsFragment();
        }



        @Override
        public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {

            View view = inflater.inflate(R.layout.fragment_listing, container, false);
            RecyclerView rvContacts = (RecyclerView) view.findViewById(R.id.rvContacts);
            rvContacts.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(getActivity());

            contacts = Contact.createContactsList(20);
            // Create adapter passing in the sample user data
            ContactsAdapter adapter = new ContactsAdapter(contacts);
            // Attach the adapter to the recyclerview to populate items
            rvContacts.setAdapter(adapter);
            // Set layout manager to position the items
            rvContacts.setLayoutManager(mLayoutManager);
            // That's all!

            //((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(FRAGMENT_TITLE);

            return view;
        }

    }

