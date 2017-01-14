package Model;

import java.util.ArrayList;

/**
 * This is the example from CodePath. I used it to understand how to actually use the recyclerView
 *
 * @author apill
 */
public class Contact
{
    private String mName;
    private boolean mOnline;

    public Contact(String name, boolean online)
    {
        mName = name;
        mOnline = online;
    }

    public String getName() {
        return mName;
    }

    public boolean isOnline() {
        return mOnline;
    }

    private static int lastContactId = 0;

    public static ArrayList<Contact> createContactsList(int numContacts)
    {
        ArrayList<Contact> contacts = new ArrayList<Contact>();

        for (int i = 1; i <= numContacts; i++) {
            contacts.add(new Contact("Person " + ++lastContactId, i <= numContacts / 2));
        }
        System.out.println(contacts);

        return contacts;
    }
}
