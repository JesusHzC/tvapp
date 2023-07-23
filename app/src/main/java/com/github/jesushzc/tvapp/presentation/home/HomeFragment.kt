package com.github.jesushzc.tvapp.presentation.home

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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
        setupToolbar()
        viewModel.getTvPrograms()
        initObservers()
        setupEditTextSearch()
    }

    private fun setupToolbar() {
        binding.toolbar.apply {
            tvDate.text = viewModel.getTitleDate()
            ivSearch.setOnClickListener {
                etSearch.show()
                tvDate.hide()
                ivSearch.hide()
                ivClose.show()
            }
            ivClose.setOnClickListener {
                etSearch.hide()
                tvDate.show()
                ivSearch.show()
                ivClose.hide()
                etSearch.text.clear()
                viewModel.getTvPrograms()
            }
        }
    }

    private fun setupEditTextSearch() {
        binding.toolbar.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                viewModel.getTvPrograms(s.toString())
            }
        })
    }

    private fun initObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.tvPrograms.collect { data ->
                if (data.isNotEmpty()) {
                    binding.emptyDataLayout.tvEmptyData.hide()
                    binding.rvShows.show()
                    if (this@HomeFragment::adapter.isInitialized)
                        adapter.updateData(data)
                    else {
                        adapter = TvProgramAdapter(data.toMutableList())
                        binding.rvShows.layoutManager = LinearLayoutManager(requireContext())
                        binding.rvShows.adapter = adapter
                    }
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