package com.example.notepadthoughts.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.notepadthoughts.R
import com.example.notepadthoughts.databinding.FragmentHomeBinding
import com.example.notepadthoughts.models.Notes
import com.example.notepadthoughts.ui.adapter.PinnedRVAdapter


class HomeFragment : Fragment() {
   private var mBinding: FragmentHomeBinding? = null
   private val binding get() = mBinding!!

   override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View {
      mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
      return binding.root
   }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)

      setupPinnedRecyclerView()
   }

   private fun setupPinnedRecyclerView() {
      val data:ArrayList<Notes> = ArrayList()
      data.add(Notes("test 1", "test 1"))
      data.add(Notes("test 2", "test 2"))
      data.add(Notes("test 3", "test 3"))
      data.add(Notes("test 4", "test 4"))
      data.add(Notes("test 5", "test 5"))

      if (data.isEmpty()) {
         binding.pinnedCon.visibility = View.GONE
      }else{
         binding.pinnedCon.visibility = View.VISIBLE
      }
      binding.pinnedRv.adapter = PinnedRVAdapter(data)
   }

   override fun onDestroy() {
      super.onDestroy()
      mBinding = null
   }


}