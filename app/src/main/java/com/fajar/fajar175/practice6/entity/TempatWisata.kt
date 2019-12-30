package com.fajar.fajar175.practice6.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "tempat_wisata_table")
data class TempatWisata(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Int,
    @ColumnInfo(name = "nama") var nama: String,
    @ColumnInfo(name = "alamat") var alamat: String,
    @ColumnInfo(name = "deskripsi") var deskripsi: String,
    @ColumnInfo(name = "gambar") var gambar: String
): Parcelable