package com.box.contacts.fragments
import android.os.Bundle
import android.provider.ContactsContract
import android.support.v4.content.CursorLoader
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.box.contacts.ContactsListAdapter
import com.box.contacts.R
import com.box.contacts.models.Contact
import java.util.HashMap

class ContactsFragment : ViewPagerFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val contacts = getContacts()
        val contactsList = inflater.inflate(R.layout.contacts_list, container, false) as RecyclerView
        contactsList.adapter = ContactsListAdapter(contacts)
        contactsList.layoutManager = LinearLayoutManager(this.context)
        return contactsList
    }

    fun getContacts() : ArrayList<Contact> {
        val contacts = ArrayList<Contact>()
        val projection = arrayOf(ContactsContract.Contacts._ID,
            ContactsContract.Contacts.LOOKUP_KEY,
            ContactsContract.Contacts.DISPLAY_NAME)
        val cursorLoader = CursorLoader(this.context!!,
            ContactsContract.Contacts.CONTENT_URI,
            projection, null, null, null)
        val cursor = cursorLoader.loadInBackground()

        if (cursor?.moveToFirst() == true) {
            do {
                val idIndex = cursor.getColumnIndex(ContactsContract.Contacts._ID)
                val lookUpIndex = cursor.getColumnIndex(ContactsContract.Contacts.LOOKUP_KEY)
                 val nameIndex = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
               val contactId = cursor.getInt(idIndex)
                val lookUpKey = cursor.getString(lookUpIndex)
                val contactDisplayName = cursor.getString(nameIndex)
                val contact = Contact(contactId, lookUpKey, contactDisplayName)

                contacts.add(contact)
            } while (cursor.moveToNext())
        }

        return contacts
    }
}