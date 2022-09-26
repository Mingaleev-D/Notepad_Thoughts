package com.example.notepadthoughts.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

/**
 * @author : Mingaleev D
 * @data : 17/09/2022
 */
@TypeConverters(NoteTypeConverter::class)
@Database(entities = [NotesEntity::class], version = 1)
abstract class NotesDatabase:RoomDatabase() {
   abstract fun noteDao():NotesDao
}