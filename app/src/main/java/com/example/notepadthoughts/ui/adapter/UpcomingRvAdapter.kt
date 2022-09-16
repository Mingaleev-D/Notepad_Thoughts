package com.example.notepadthoughts.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.notepadthoughts.R
import com.example.notepadthoughts.databinding.UpcomingRvItemsBinding
import com.example.notepadthoughts.models.Notes

/**
 * @author : Mingaleev D
 * @data : 16/09/2022
 */

class UpcomingRvAdapter(private val model: ArrayList<Notes>) :
   RecyclerView.Adapter<UpcomingRvAdapter.MyViewHolder>() {

   class MyViewHolder(private val binding: UpcomingRvItemsBinding) :
      RecyclerView.ViewHolder(binding.root) {
      fun bind(notesModel: Notes) {
         binding.pinnedtitle11.text = notesModel.title
         binding.pinneddescription11.text = notesModel.note
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
      holder.bind(model[position])
   }

   override fun getItemCount(): Int = model.size
}