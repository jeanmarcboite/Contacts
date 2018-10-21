package com.box.contacts.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.box.contacts.MainActivity
import com.box.contacts.R
import kotlinx.android.synthetic.main.fragment_main.view.*

class ContactsFragment() : ViewPagerFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_main, container, false)
        rootView.section_label.text = "Contacts"
        return rootView
    }
}