package com.example.notepadthoughts.repository

import com.example.notepadthoughts.db.NotesDatabase
import com.example.notepadthoughts.db.NotesEntity
import com.example.notepadthoughts.models.Notes
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 26/09/2022
 */

class NotesRepository @Inject constructor(
  private val notesDatabase: NotesDatabase
) {
  private val roomDao = notesDatabase.noteDao()

  suspend fun insertNote(notes: Notes){
    val noteEntity = NotesEntity(0,notes)
    roomDao.insert(noteEntity)
  }

  fun getAllData():Flow<List<NotesEntity>>{
    return roomDao.getAll()
  }
  suspend fun updateNote(noteEntity: NotesEntity){
    roomDao.update(noteEntity)
  }
}