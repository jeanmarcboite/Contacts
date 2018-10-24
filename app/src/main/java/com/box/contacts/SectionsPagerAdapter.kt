package com.box.contacts

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.box.contacts.fragments.*

val tabTitles = arrayOf("Contacts", "Dictionary", "Other", "Default")

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */

class SectionsPagerAdapter (fm: FragmentManager) : FragmentPagerAdapter(fm) {
    // getItem is called to instantiate the fragment for the given page.
       override fun getItem(position: Int): Fragment {
           return when (position) {
               0 -> ContactsFragment()
               1 -> DictionaryFragment()
               2 -> OtherFragment()
               else -> ViewPagerFragment.newInstance(position + 1)
           }
        }

        override fun getCount(): Int {
            return tabTitles.count()
        }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitles[position]
    }
}