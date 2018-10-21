package com.box.contacts.fragments
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.box.contacts.ContactsListAdapter
import com.box.contacts.R

class ContactsFragment : ViewPagerFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dataSet = arrayOf("ZERO", "one", "Two")
        val contactsList = inflater.inflate(R.layout.contacts_list, container, false) as RecyclerView
        contactsList.adapter = ContactsListAdapter(dataSet)
        contactsList.layoutManager = LinearLayoutManager(this.context)
        return contactsList
    }
}