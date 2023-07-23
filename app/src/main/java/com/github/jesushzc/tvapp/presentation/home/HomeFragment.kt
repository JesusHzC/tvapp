package com.github.jesushzc.tvapp.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.jesushzc.tvapp.databinding.FragmentHomeBinding
import com.github.jesushzc.tvapp.presentation.home.adapter.TvProgramAdapter
import com.github.jesushzc.tvapp.utils.hide
import com.github.jesushzc.tvapp.utils.show
import com.github.jesushzc.tvapp.utils.showDialogError
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var adapter: TvProgramAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding
            .inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getTvPrograms()
        initObservers()
    }

    private fun initObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.tvPrograms.collect { data ->
                if (data.isNotEmpty()) {
                    binding.emptyDataLayout.tvEmptyData.hide()
                    binding.rvShows.show()
                    adapter = TvProgramAdapter(data)
                    binding.rvShows.layoutManager = LinearLayoutManager(requireContext())
                    binding.rvShows.adapter = adapter
                } else {
                    binding.rvShows.hide()
                    binding.emptyDataLayout.tvEmptyData.show()
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.isLoading.collect { isLoading ->
                if (isLoading) {
                    binding.loaderLayout.loader.show()
                } else {
                    binding.loaderLayout.loader.hide()
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.isError.collect { isErrorPair ->
                val isError = isErrorPair.first
                val errorMessage = isErrorPair.second
                if (isError) {
                    showDialogError(
                        requireContext(),
                        errorMessage
                    ) {
                        viewModel.setIsError(false)
                        viewModel.getTvPrograms()
                    }
                }
            }
        }
    }

}