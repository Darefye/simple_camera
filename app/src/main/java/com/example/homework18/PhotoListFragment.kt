package com.example.homework18

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.homework18.adapters.PhotoListAdapter
import com.example.homework18.databinding.PhotoListFragmentBinding
import com.example.homework18.viewmodels.PhotoListViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


class PhotoListFragment : Fragment() {

    private var _binding: PhotoListFragmentBinding? = null
    private val binding get() = _binding!!

    private val photoListAdapter = PhotoListAdapter()

    private val viewModel: PhotoListViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val userDao = (activity!!.application as App).db.userDao()
                return PhotoListViewModel(userDao) as T
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = PhotoListFragmentBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.adapter = photoListAdapter

        viewModel.allPhoto.onEach {
            photoListAdapter.setData(it)
        }.launchIn(viewLifecycleOwner.lifecycleScope)

        binding.buttonCreatePhoto.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}