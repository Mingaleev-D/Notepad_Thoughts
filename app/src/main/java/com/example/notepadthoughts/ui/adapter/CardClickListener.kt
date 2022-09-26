package com.example.notepadthoughts.ui.adapter

import com.example.notepadthoughts.db.NotesEntity

/**
 * @author : Mingaleev D
 * @data : 26/09/2022
 */

interface CardClickListener {
  fun onItemClickListener(noteEntity: NotesEntity)
}