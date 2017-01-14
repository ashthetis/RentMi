package Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.rentmi.rentmi.R;
import java.util.List;
import Model.Contact;

/**
 * The Adapter and Viewholder to hold and populate the view
 *
 * @author apill
 */

public class ContactsAdapter extends
        RecyclerView.Adapter<ContactsAdapter.ViewHolder>
{

    public static class ViewHolder extends RecyclerView.ViewHolder
    {

        public TextView nameTextView;
        public Button messageButton;

        public ViewHolder(View itemView)
        {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
            messageButton = (Button) itemView.findViewById(R.id.message_button);
        }
    }
    private List<Contact> mContacts;

    public ContactsAdapter( List<Contact> contacts)
    {
        mContacts = contacts;

    }

    @Override
    public ContactsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_contact, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(ContactsAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Contact contact = mContacts.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.nameTextView;
        textView.setText(contact.getName());
        Button button = viewHolder.messageButton;
        button.setText("Message");
    }
    @Override
    public int getItemCount() {
        return mContacts.size();
    }
}
