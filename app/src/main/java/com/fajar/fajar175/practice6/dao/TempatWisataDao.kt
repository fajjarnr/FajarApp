package com.fajar.fajar175.practice6.dao

import android.database.Cursor
import androidx.lifecycle.LiveData
import androidx.room.*
import com.fajar.fajar175.practice6.entity.TempatWisata

@Dao
interface TempatWisataDao {
    @Query("SELECT * from tempat_wisata_table ORDER BY nama ASC")
    fun getAlphabetizedTempatWisata(): LiveData<List<TempatWisata>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(tempatWisata: TempatWisata)

    @Query("UPDATE tempat_wisata_table SET nama =:strNama, alamat =:strAlamat, deskripsi =:strDeskripsi, gambar =:strUrl WHERE id =:Intid")
    fun update(Intid: Int, strNama: String, strAlamat: String, strDeskripsi: String, strUrl: String)

    @Query("DELETE FROM tempat_wisata_table")
    suspend fun deleteAll()

    @Delete
    fun delete(tempatWisata: TempatWisata)

    @Query("SELECT * FROM tempat_wisata_table")
    fun getCursorAll(): Cursor
}