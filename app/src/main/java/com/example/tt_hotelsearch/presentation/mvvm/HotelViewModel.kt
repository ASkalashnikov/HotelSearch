package com.example.tt_hotelsearch.presentation.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tt_hotelsearch.domain.adapter.ListItem
import com.example.tt_hotelsearch.domain.usecase.GetHotelListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HotelViewModel @Inject constructor(
    private val getHotelListUseCase: GetHotelListUseCase
): ViewModel() {

    private val _recyclerViewVM = MutableLiveData<List<ListItem>>()
    val recyclerViewVM: LiveData<List<ListItem>> = _recyclerViewVM

    fun getHotelList() {
        _recyclerViewVM.value = getHotelListUseCase.execute()
    }
}