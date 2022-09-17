package com.example.notepadthoughts.db

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * @author : Mingaleev D
 * @data : 17/09/2022
 */
@Database(entities = [NotesEntity::class], version = 1)
abstract class NotesDatabase:RoomDatabase() {
   abstract fun noteDao():NotesDao
}