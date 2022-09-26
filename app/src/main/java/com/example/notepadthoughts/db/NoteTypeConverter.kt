package com.example.notepadthoughts.db

import androidx.room.TypeConverter
import com.example.notepadthoughts.models.Notes
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

/**
 * @author : Mingaleev D
 * @data : 26/09/2022
 */

class NoteTypeConverter {

  @TypeConverter
  fun tojson(notes: Notes): String? {
    if (notes == null) {
      return null
    }
    val gson = Gson()
    val type: Type = object : TypeToken<Notes?>() {}.getType()
    return gson.toJson(notes, type)
  }

  @TypeConverter
  fun toDataClass(note: String?): Notes? {
    if (note == null) {
      return null
    }
    val gson = Gson()
    val type: Type = object : TypeToken<Notes?>() {}.getType()
    return gson.fromJson(note, type)
  }
}