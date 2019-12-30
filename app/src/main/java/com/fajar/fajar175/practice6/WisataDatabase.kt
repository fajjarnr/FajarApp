package com.fajar.fajar175.practice6

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fajar.fajar175.practice6.dao.TempatWisataDao
import com.fajar.fajar175.practice6.entity.TempatWisata
import kotlinx.coroutines.CoroutineScope

@Database(entities = arrayOf(TempatWisata::class), version = 1, exportSchema = false)
public abstract class WisataDatabase : RoomDatabase() {
    abstract fun tempatWisataDao(): TempatWisataDao

    companion object {
        @Volatile
        private var INSTANCE: WisataDatabase? = null

        fun getDatabase(
            context: Context,
            viewModelScope: CoroutineScope
        ): WisataDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WisataDatabase::class.java,
                    "wisata_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

        fun getInstance(context: Context): WisataDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                WisataDatabase::class.java, "wisata_database.db"
            )
                .build()
    }
}