package com.example.notepadthoughts.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.notepadthoughts.R
import com.example.notepadthoughts.databinding.UpcomingRvItemsBinding
import com.example.notepadthoughts.db.NotesEntity

/**
 * @author : Mingaleev D
 * @data : 16/09/2022
 */

class UpcomingRvAdapter(private val model: ArrayList<NotesEntity>,private var listener: CardClickListener) :
   RecyclerView.Adapter<UpcomingRvAdapter.MyViewHolder>() {

   class MyViewHolder(private val binding: UpcomingRvItemsBinding) :
      RecyclerView.ViewHolder(binding.root) {

      fun bind(noteEntity: NotesEntity, listener: CardClickListener) {

         binding.upcomingCard.setCardBackgroundColor(Color.parseColor(noteEntity.notesModel.color))

         binding.pinnedtitle11.text = noteEntity.notesModel.title
         binding.pinneddescription11.text = noteEntity.notesModel.note

         binding.upcomingCard.setOnClickListener {
          listener.onItemClickListener(noteEntity)
         }

         binding.executePendingBindings()
      }
   }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val upcomingRvItemsBinding: UpcomingRvItemsBinding = DataBindingUtil.inflate(
         LayoutInflater.from(parent.context),
         R.layout.upcoming_rv_items,
         parent,
         false
      )
      return MyViewHolder(upcomingRvItemsBinding)
   }

   override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      holder.bind(model[position],listener)
   }

   override fun getItemCount(): Int = model.size
}