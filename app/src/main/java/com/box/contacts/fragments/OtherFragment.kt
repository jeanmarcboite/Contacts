package com.box.contacts.fragments
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.box.contacts.OtherListAdapter
import com.box.contacts.R

class OtherFragment : ViewPagerFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dataSet = arrayOf("ZERO", "one", "Two")
        val otherList = inflater.inflate(R.layout.other_list, container, false) as RecyclerView
        otherList.adapter = OtherListAdapter(dataSet)
        otherList.layoutManager = LinearLayoutManager(this.context)
        return otherList
    }
}