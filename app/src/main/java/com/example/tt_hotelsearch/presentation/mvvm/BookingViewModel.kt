package com.example.tt_hotelsearch.presentation.mvvm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tt_hotelsearch.domain.adapter.ListItem
import com.example.tt_hotelsearch.domain.usecase.CheckingEditTextBookingUseCase
import com.example.tt_hotelsearch.domain.usecase.GetBookingListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BookingViewModel @Inject constructor(
    private val context: Application,
    private val getBookingListUseCase: GetBookingListUseCase,
    private val checkingEditTextBookingUseCase: CheckingEditTextBookingUseCase,
) : AndroidViewModel(context) {

    private val _recyclerViewVM = MutableLiveData<List<ListItem>>()
    val recyclerViewVM: LiveData<List<ListItem>> = _recyclerViewVM

    private val _checkingEditTextVM = MutableLiveData<Boolean>()
    val checkingEditTextVM: LiveData<Boolean> = _checkingEditTextVM

    fun getBookingList(addTourist: Int) {
        _recyclerViewVM.value = getBookingListUseCase.execute(addTourist)
    }

    fun checkingEditText() {
        _checkingEditTextVM.value = checkingEditTextBookingUseCase.execute(context, true)
    }
}