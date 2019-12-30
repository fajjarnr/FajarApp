package com.fajar.fajar175.practice6.provider

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import com.fajar.fajar175.practice6.WisataDatabase
import com.fajar.fajar175.practice6.dao.TempatWisataDao

class DataContentProvider : ContentProvider() {

    companion object {
        private lateinit var tempatWisataDAO: TempatWisataDao
        private const val TABLE = 1
        private const val AUTHORITY = "com.fajar.fajar175.datawisata"
        private val uriMatcher = UriMatcher(UriMatcher.NO_MATCH)
    }

    init {
        uriMatcher.addURI(AUTHORITY, "tempat_wisata_table", 1)
        uriMatcher.addURI(AUTHORITY, "tempat_wisata/*", 2)
    }

    override fun onCreate(): Boolean {
        tempatWisataDAO = WisataDatabase.getInstance(context!!).tempatWisataDao()
        return true
    }

    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?, selectionArgs: Array<String>?,
        sortOrder: String?
    ): Cursor? {
        var cursor: Cursor? = null
        when (uriMatcher.match(uri)) {
            TABLE -> cursor = tempatWisataDAO.getCursorAll()
            else -> cursor = null
        }
        return cursor
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        TODO("Implement this to handle requests to delete one or more rows")
    }

    override fun getType(uri: Uri): String? {
        TODO(
            "Implement this to handle requests for the MIME type of the data" +
                    "at the given URI"
        )
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        TODO("Implement this to handle requests to insert a new row.")
    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        TODO("Implement this to handle requests to update one or more rows.")
    }
}
