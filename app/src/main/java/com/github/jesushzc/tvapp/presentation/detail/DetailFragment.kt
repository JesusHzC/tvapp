package com.github.jesushzc.tvapp.presentation.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.github.jesushzc.tvapp.R
import com.github.jesushzc.tvapp.databinding.FragmentDetailBinding
import com.github.jesushzc.tvapp.domain.model.Show
import com.github.jesushzc.tvapp.presentation.detail.adapter.CastAdapter
import com.github.jesushzc.tvapp.utils.hide
import com.github.jesushzc.tvapp.utils.show
import com.github.jesushzc.tvapp.utils.showDialogError
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private var idTvProgram: Int? = null

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DetailViewModel by viewModels()

    private lateinit var adapter: CastAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            idTvProgram = it.getInt(ID_TV_PROGRAM)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding
            .inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (idTvProgram != null && idTvProgram != 0) {
            viewModel.getDetailShow(idTvProgram!!)
            viewModel.getCast(idTvProgram!!)
        }
        initObservers()
    }

    private fun initObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.tvShow.collect { show ->
                if (show != null) {
                    binding.emptyDataLayout.tvEmptyData.hide()
                    binding.llDetail.show()
                    loadShowData(show)
                } else {
                    binding.llDetail.hide()
                    binding.emptyDataLayout.tvEmptyData.show()
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.cast.collect { data ->
                if (data.isNotEmpty()) {
                    binding.tvShowTalents.show()
                    binding.rvShowTalents.show()
                    adapter = CastAdapter(data)
                    binding.rvShowTalents.layoutManager =
                        LinearLayoutManager(
                            requireContext(),
                            LinearLayoutManager.HORIZONTAL,
                            false
                        )
                    binding.rvShowTalents.adapter = adapter
                } else {
                    binding.tvShowTalents.hide()
                    binding.rvShowTalents.hide()
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
                        if (idTvProgram != null && idTvProgram != 0) {
                            viewModel.getDetailShow(idTvProgram!!)
                            viewModel.getCast(idTvProgram!!)
                        }
                    }
                }
            }
        }
    }

    private fun loadShowData(show: Show) {
        binding.apply {
            Glide.with(requireContext())
                .load(show.image?.medium)
                .centerCrop()
                .into(ivShowPoster)

            tvShowName.text = show.name
            tvShowNetwork.text = show.network?.name ?: ""
            tvShowRanking.text = if (show.rating?.average != null) show.rating?.average.toString() else getString(
                R.string.no_rating
            )

            btnGoToWebsite.setOnClickListener {
                openNavigator(show.url)
            }

            tvShowSinopsis.text = Html.fromHtml(show.summary, Html.FROM_HTML_MODE_COMPACT)
            tvShowGenres.text = show.genres.joinToString(", ").ifEmpty { context?.getString(R.string.no_genres) }
            tvShowSchedule.text = requireContext().getString(
                R.string.date_time_string,
                show.schedule?.time?.ifEmpty { context?.getString(R.string.no_time) },
                show.schedule?.days?.joinToString(", ")?.ifEmpty { context?.getString(R.string.no_days) }
            )
        }
    }

    private fun openNavigator(url: String?) {
        if (url.isNullOrEmpty().not()) {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        } else {
            Toast.makeText(
                requireContext(),
                getString(R.string.error_opening_url),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    companion object {
        const val ID_TV_PROGRAM = "id_tv_program"
    }
}