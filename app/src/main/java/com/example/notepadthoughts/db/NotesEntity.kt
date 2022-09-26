package com.example.notepadthoughts.db

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.notepadthoughts.models.Notes
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "notetable")

data class NotesEntity(
   @PrimaryKey(autoGenerate = true)
   val id:Int,
   val notesModel:Notes
): Parcelable {
   constructor(parcel: Parcel) : this(
      parcel.readInt(),
      TODO("notesModel")
   ) {
   }

   override fun writeToParcel(parcel: Parcel, flags: Int) {
      parcel.writeInt(id)
   }

   override fun describeContents(): Int {
      return 0
   }

   companion object CREATOR : Parcelable.Creator<NotesEntity> {
      override fun createFromParcel(parcel: Parcel): NotesEntity {
         return NotesEntity(parcel)
      }

      override fun newArray(size: Int): Array<NotesEntity?> {
         return arrayOfNulls(size)
      }
   }
}
