package com.box.contacts.fragments
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.box.contacts.ContactListAdapter
import com.box.contacts.MainActivity
import com.box.contacts.R
import kotlinx.android.synthetic.main.contacts_list.view.*
import kotlinx.android.synthetic.main.fragment_main.view.*

class ContactsFragment() : ViewPagerFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dataSet = arrayOf("ZERO", "one", "Two")
        val contactsList = inflater.inflate(R.layout.contacts_list, container, false) as RecyclerView
        contactsList.adapter = ContactListAdapter(dataSet)
        contactsList.layoutManager = LinearLayoutManager(this.context)
        return contactsList
    }
}