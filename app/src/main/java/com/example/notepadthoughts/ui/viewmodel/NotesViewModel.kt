package com.example.notepadthoughts.ui.viewmodel

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notepadthoughts.db.NotesEntity
import com.example.notepadthoughts.models.Notes
import com.example.notepadthoughts.repository.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 26/09/2022
 */
@HiltViewModel
class NotesViewModel @Inject constructor(
  private val repository: NotesRepository
) : ViewModel() {

  init {
    getAllDataFromDb()
  }

  private var _data:MutableLiveData<List<NotesEntity>> = MutableLiveData()
  var liveData:LiveData<List<NotesEntity>> = _data

  fun insertNoteToDatabase(note: Notes) = viewModelScope.launch(Dispatchers.IO) {
    repository.insertNote(note)
  }
  fun getAllDataFromDb() = viewModelScope.launch(Dispatchers.IO) {
    repository.getAllData().collect{
      _data.postValue(it)
    }
  }
  fun updateNoteDatabase(noteEntity:NotesEntity) = viewModelScope.launch(Dispatchers.IO) {
    repository.updateNote(noteEntity)
  }
}