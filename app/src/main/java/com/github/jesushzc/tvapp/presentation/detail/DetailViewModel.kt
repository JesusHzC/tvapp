package com.github.jesushzc.tvapp.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.jesushzc.tvapp.domain.model.Show
import com.github.jesushzc.tvapp.domain.model.Talent
import com.github.jesushzc.tvapp.domain.use_case.CastUseCase
import com.github.jesushzc.tvapp.domain.use_case.TvProgramDetailUseCase
import com.github.jesushzc.tvapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val tvProgramDetailUseCase: TvProgramDetailUseCase,
    private val castUseCase: CastUseCase
) : ViewModel() {

    private val _isLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    private val _isError: MutableStateFlow<Pair<Boolean, String>> = MutableStateFlow(Pair(false, ""))
    val isError: StateFlow<Pair<Boolean, String>> get() = _isError

    private val _tvShow: MutableStateFlow<Show?> = MutableStateFlow(null)
    val tvShow: StateFlow<Show?> get() = _tvShow

    private val _cast: MutableStateFlow<List<Talent>> = MutableStateFlow(emptyList())
    val cast: StateFlow<List<Talent>> get() = _cast

    fun getDetailShow(id: Int) {
        _isLoading.update { true }
        viewModelScope.launch {
            when (val response = tvProgramDetailUseCase.invoke(id)) {
                is Resource.Success -> {
                    _tvShow.update { response.data }
                    _isLoading.update { false }
                }
                is Resource.Error -> {
                    _isError.update { Pair(true, response.message ?: "Error") }
                    _isLoading.update { false }
                }
            }
        }
    }

    fun getCast(id: Int) {
        viewModelScope.launch {
            when (val response = castUseCase.invoke(id)) {
                is Resource.Success -> {
                    _cast.update { response.data?.talents ?: emptyList() }
                }
                is Resource.Error -> Unit
            }
        }
    }

    fun setIsError(isError: Boolean) {
        _isError.update { Pair(isError, "") }
    }

}