package com.example.notepadthoughts.di

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
   fun provideString():String {
      return "notes_app"
   }

}