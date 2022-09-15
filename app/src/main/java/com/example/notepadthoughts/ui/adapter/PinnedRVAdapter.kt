package com.example.notepadthoughts.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.PrecomputedTextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.notepadthoughts.R
import com.example.notepadthoughts.databinding.PinnedRvItemsBinding
import com.example.notepadthoughts.models.Notes

/**
 * @author : Mingaleev D
 * @data : 15/09/2022
 */

class PinnedRVAdapter(private var data: ArrayList<Notes>) :
   RecyclerView.Adapter<PinnedRVAdapter.MyPinnedViewHolder>() {

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPinnedViewHolder {
      val pinnedRvItemsBinding: PinnedRvItemsBinding = DataBindingUtil.inflate(
         LayoutInflater.from(parent.context),
         R.layout.pinned_rv_items, parent, false
      )
      return MyPinnedViewHolder(pinnedRvItemsBinding)
   }

   override fun onBindViewHolder(holder: MyPinnedViewHolder, position: Int) {
      holder.bind(data[position])
   }

   override fun getItemCount(): Int = data.size

   class MyPinnedViewHolder(private val binding: PinnedRvItemsBinding) :
      RecyclerView.ViewHolder(binding.root) {
      fun bind(notesModel: Notes) {
         binding.pinnedtitle.setTextFuture(
            PrecomputedTextCompat.getTextFuture(
               notesModel.title,
               binding.pinnedtitle.textMetricsParamsCompat,
               null
            )
         )
         binding.pinneddescription.text = notesModel.note
         binding.executePendingBindings()
      }

   }
}