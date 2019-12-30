package com.fajar.fajar175.practice6

import androidx.lifecycle.LiveData
import com.fajar.fajar175.practice6.dao.TempatWisataDao
import com.fajar.fajar175.practice6.entity.TempatWisata
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class DatabaseRepository(private val tempatWisataDao: TempatWisataDao) {
    val allTempatWisata: LiveData<List<TempatWisata>> =
        tempatWisataDao.getAlphabetizedTempatWisata()

    suspend fun insert(listTempatWisata: TempatWisata) {
        tempatWisataDao.insert(listTempatWisata)
    }

    fun update(listTempatWisata: TempatWisata) {
        doAsync {
            tempatWisataDao.update(
                listTempatWisata.id,
                listTempatWisata.nama,
                listTempatWisata.alamat,
                listTempatWisata.deskripsi,
                listTempatWisata.gambar
            )
            uiThread {
            }
        }
    }

    fun deleteData(listTempatWisata: TempatWisata) {
        doAsync {
            tempatWisataDao.delete(listTempatWisata)
            uiThread {
            }
        }
    }
}