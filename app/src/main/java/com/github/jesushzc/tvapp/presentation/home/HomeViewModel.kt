package com.github.jesushzc.tvapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.jesushzc.tvapp.domain.model.TvProgram
import com.github.jesushzc.tvapp.domain.use_case.DateFormatterUseCase
import com.github.jesushzc.tvapp.domain.use_case.TvProgramUseCase
import com.github.jesushzc.tvapp.utils.Resource
import com.github.jesushzc.tvapp.utils.TypeDateFormat
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val tvProgramUseCase: TvProgramUseCase,
    private val dateFormatterUseCase: DateFormatterUseCase
): ViewModel() {

    private val _isLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    private val _isError: MutableStateFlow<Pair<Boolean, String>> = MutableStateFlow(Pair(false, ""))
    val isError: StateFlow<Pair<Boolean, String>> get() = _isError

    private val _tvPrograms: MutableStateFlow<List<TvProgram>> = MutableStateFlow(emptyList())
    val tvPrograms: StateFlow<List<TvProgram>> get() = _tvPrograms

    fun getTvPrograms() {
        _isLoading.update { true }
        viewModelScope.launch {
            when (val response = tvProgramUseCase.invoke(dateFormatterUseCase(TypeDateFormat.DATE_ISO))) {
                is Resource.Success -> {
                    _tvPrograms.update { response.data?.tvPrograms ?: emptyList() }
                    _isLoading.update { false }
                }
                is Resource.Error -> {
                    _isError.update { Pair(true, response.message ?: "Error") }
                    _isLoading.update { false }
                }
            }
        }
    }

    fun setIsError(isError: Boolean) {
        _isError.update { Pair(isError, "") }
    }

}