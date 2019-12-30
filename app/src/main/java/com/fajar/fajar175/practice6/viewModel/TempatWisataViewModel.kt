package com.fajar.fajar175.practice6.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.fajar.fajar175.practice6.DatabaseRepository
import com.fajar.fajar175.practice6.WisataDatabase
import com.fajar.fajar175.practice6.entity.TempatWisata
import kotlinx.coroutines.launch

class TempatWisataViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: DatabaseRepository
    val allTempatWisata: LiveData<List<TempatWisata>>
    init {
        val tempatWisataDao = WisataDatabase.getDatabase(application,
            viewModelScope).tempatWisataDao()
        repository = DatabaseRepository(tempatWisataDao)
        allTempatWisata = repository.allTempatWisata
    }
    fun insert(listTempatWisata: TempatWisata) = viewModelScope.launch {
        repository.insert(listTempatWisata)
    }
    fun update(listTempatWisata: TempatWisata) = viewModelScope.launch {
        repository.update(listTempatWisata)
    }
    fun deleteData(listTempatWisata: TempatWisata) = viewModelScope.launch {
        repository.deleteData(listTempatWisata)
    }
}