package com.example.notepadthoughts.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.notepadthoughts.models.Notes

@Entity(tableName = "notetable")
data class NotesEntity(
   @PrimaryKey(autoGenerate = true)
   val id:Int,
   val notesModel:Notes
)
