package com.box.contacts.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.box.contacts.R
import android.provider.UserDictionary
import android.content.ContentResolver
import android.support.v4.content.CursorLoader
import android.widget.TextView
import com.box.contacts.models.Word


class DictionaryFragment: ViewPagerFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val wordsList = inflater.inflate(R.layout.contacts_list, container, false) as RecyclerView
        wordsList.adapter = DictionaryAdapter(getWords())
        wordsList.layoutManager = LinearLayoutManager(this.context)

        return wordsList
    }

    fun getWords() : ArrayList<Word> {
        val words = ArrayList<Word>()
        val context = this.context!!
        val cursorLoader = CursorLoader(context,
            UserDictionary.Words.CONTENT_URI, null, null, null, null)
        val cursor = cursorLoader.loadInBackground()

        if (cursor?.moveToFirst() == true)
            do words.add(Word(cursor))
                while (cursor.moveToNext())

        return words
    }

    class DictionaryAdapter(val words: ArrayList<Word>)
        : RecyclerView.Adapter<DictionaryAdapter.DictionaryViewHolder>() {
        class DictionaryViewHolder(val view: View) : RecyclerView.ViewHolder(view)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
                : DictionaryViewHolder {
            return DictionaryViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.word, parent, false))
        }

        override fun onBindViewHolder(holder: DictionaryViewHolder, position: Int) {
            holder.view.findViewById<TextView>(R.id.tvWord).text = words[position].word
        }

        override fun getItemCount() = words.size
    }
}