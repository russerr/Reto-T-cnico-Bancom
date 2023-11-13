package com.russerdev.presentation.home

import androidx.lifecycle.ViewModel
import com.russerdev.domain.uses_cases.HomeUsesCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUsesCases: HomeUsesCases
): ViewModel() {

}