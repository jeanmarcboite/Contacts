package com.box.contacts.models

import android.content.Context
import android.database.Cursor
import android.provider.ContactsContract

data class Contact(val context: Context, val cursor: Cursor) {
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
    val phoneNumber = getPhoneNumbers()
    override fun toString(): String {
        return "$ID $displayName ($displayNameAlternative) [$phoneticName] $phoneNumber"
    }

    fun getPhoneNumbers(): ArrayList<String> {
        val phoneNumbers = ArrayList<String>()
        phoneNumbers.add("+")
        if (hasPhoneNumber > 0) {
        val phones = context.getContentResolver().query( ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
            ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = "+ ID, null, null)
           if (phones?.moveToFirst() == true) {
               while (phones.moveToNext()) {
                   val phoneNumber =
                       phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                   phoneNumbers[0] = phoneNumber
               }
           }
            phones?.close()
        }
        return phoneNumbers
    }
/*
    Cursor emails = getContentResolver().query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null, ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = " + contactId, null, null);

    while (emails.moveToNext()) {
        // This would allow you get several email addresses
        String emailAddress = emails.getString(
                emails.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA));
    }

    emails.close();
    */
}