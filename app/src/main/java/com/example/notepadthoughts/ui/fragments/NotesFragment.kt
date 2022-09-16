package com.example.notepadthoughts.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.notepadthoughts.R
import com.example.notepadthoughts.databinding.FragmentNotesBinding

class NotesFragment : Fragment() {
   private var mBinding: FragmentNotesBinding? = null
   private val binding get() = mBinding!!

   private var savedColor = "#64C8FD"

   override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View {
      mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_notes, container, false)
      binding.fragmentNotes = this
      return binding.root
   }
   fun onColorViewClick(check: View){

      hideAllCheck()

      check.visibility = View.VISIBLE

      binding.apply {
         when(check.id){
            this.check1.id -> savedColor = "#64C8FD"
            this.check2.id -> savedColor = "#8069FF"
            this.check3.id -> savedColor = "#FFCC36"
            this.check4.id -> savedColor = "#D77FFD"
            this.check5.id -> savedColor = "#FF419A"
            this.check6.id -> savedColor = "#7FFB76"
         }
      }

   }

   private fun hideAllCheck(){
      binding.apply {
         this.check1.visibility = View.INVISIBLE
         this.check2.visibility = View.INVISIBLE
         this.check3.visibility = View.INVISIBLE
         this.check4.visibility = View.INVISIBLE
         this.check5.visibility = View.INVISIBLE
         this.check6.visibility = View.INVISIBLE
      }
   }

   override fun onDestroy() {
      super.onDestroy()
      mBinding = null
   }


}