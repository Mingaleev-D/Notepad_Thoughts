package com.example.notepadthoughts.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

/**
 * @author : Mingaleev D
 * @data : 17/09/2022
 */
@Dao
interface NotesDao {

   @Query("SELECT * FROM notetable")
   fun getAll():Flow<List<NotesEntity>>

   @Insert
   suspend fun insert(notesEntity: NotesEntity)

   @Delete
   suspend fun delete(notesEntity: NotesEntity)

   @Update
   suspend fun update(notesEntity: NotesEntity)
}