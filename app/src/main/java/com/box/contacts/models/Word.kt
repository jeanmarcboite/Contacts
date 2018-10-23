package com.box.contacts.models

import android.database.Cursor
import android.provider.UserDictionary

fun Cursor.get(key: String) = getString(getColumnIndex(key))

data class Word(val ID: String, val word: String, val frequency: String, val locale: String) {
    companion object {
        val projection = arrayOf(
            UserDictionary.Words._ID,
            UserDictionary.Words.WORD,
              UserDictionary.Words.FREQUENCY,
              UserDictionary.Words.LOCALE
      )

    }

    constructor(cursor: Cursor) :
            this(cursor.get(UserDictionary.Words._ID),
                cursor.get(UserDictionary.Words.WORD),
                cursor.get(UserDictionary.Words.FREQUENCY),
                cursor.get(UserDictionary.Words.LOCALE))
}