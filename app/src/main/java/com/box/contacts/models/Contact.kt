package com.box.contacts.models

import android.database.Cursor
import android.provider.ContactsContract

data class Contact(val cursor: Cursor) {
    companion object {
        val projection = arrayOf(
            ContactsContract.Contacts._ID,
            ContactsContract.Contacts.LOOKUP_KEY,
            ContactsContract.Contacts.DISPLAY_NAME,
            ContactsContract.Contacts.DISPLAY_NAME_ALTERNATIVE,
            ContactsContract.Contacts.HAS_PHONE_NUMBER,
            ContactsContract.Contacts.PHONETIC_NAME,
            ContactsContract.Contacts.STARRED
        )

    }

    val ID = cursor.getInt(cursor.getColumnIndex(ContactsContract.Contacts._ID))
    val lookUpKey = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.LOOKUP_KEY))
    val displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
    val displayNameAlternative = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME_ALTERNATIVE))
    val hasPhoneNumber = cursor.getInt(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))
    val phoneticName = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.PHONETIC_NAME))
    val starred = cursor.getInt(cursor.getColumnIndex(ContactsContract.Contacts.STARRED))

    override fun toString(): String {
        return "$ID $displayName ($displayNameAlternative) [$phoneticName]"
    }
}