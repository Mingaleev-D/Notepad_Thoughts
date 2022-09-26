package com.example.notepadthoughts.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.notepadthoughts.R
import com.example.notepadthoughts.databinding.FragmentHomeBinding
import com.example.notepadthoughts.db.NotesEntity
import com.example.notepadthoughts.models.Notes
import com.example.notepadthoughts.ui.adapter.CardClickListener
import com.example.notepadthoughts.ui.adapter.PinnedRVAdapter
import com.example.notepadthoughts.ui.adapter.UpcomingRvAdapter
import com.example.notepadthoughts.ui.viewmodel.NotesViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment(),CardClickListener {
  private var mBinding: FragmentHomeBinding? = null
  private val binding get() = mBinding!!

  private val viewModel: NotesViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
    binding.fragmentHome = this
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    setupPinnedRecyclerView()
    setupUpcomingRecyclerView()
  }

  private fun setupUpcomingRecyclerView() {
    viewModel.liveData.observe(viewLifecycleOwner) { listData ->
      val data: ArrayList<NotesEntity> = ArrayList()
      listData.forEach {
        if (!it.notesModel.pinned) {
          data.add(it)
        }
      }
      if (data.isEmpty()) {
        binding.textView3.visibility = View.VISIBLE
      } else {
        binding.textView3.visibility = View.GONE
      }
      binding.upcomingRv.adapter = UpcomingRvAdapter(data,this)
    }
  }

  private fun setupPinnedRecyclerView() {
    viewModel.liveData.observe(viewLifecycleOwner) { listData ->
      val data: ArrayList<NotesEntity> = ArrayList()
      listData.forEach {
        if (it.notesModel.pinned) {
          data.add(it)
        }
      }
      if (data.isEmpty())
        binding.pinnedCon.visibility = View.GONE
      else
        binding.pinnedCon.visibility = View.VISIBLE

      binding.pinnedRv.adapter = PinnedRVAdapter(data,this)
    }
  }

  fun fabOnClick(view: View) {
    view.findNavController().navigate(R.id.action_homeFragment_to_notesFragment)
  }

  override fun onDestroy() {
    super.onDestroy()
    mBinding = null
  }

  override fun onItemClickListener(noteEntity: NotesEntity) {
    val bundle = bundleOf("dataModel" to noteEntity)
    Navigation.findNavController(binding.root).navigate(R.id.action_homeFragment_to_notesFragment)
  }


}