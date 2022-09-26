package com.example.notepadthoughts.di

import android.app.Application
import androidx.room.Room
import com.example.notepadthoughts.db.NotesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NotesModule {

  @Provides
  @Singleton
  fun provideDatabase(application: Application): NotesDatabase =
    Room.databaseBuilder(application, NotesDatabase::class.java, "Note_database")
      .build()
}