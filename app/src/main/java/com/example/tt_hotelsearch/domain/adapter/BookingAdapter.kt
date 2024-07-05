package com.example.tt_hotelsearch.domain.adapter

import com.example.tt_hotelsearch.domain.delegate.BookingAddTouristDelegate
import com.example.tt_hotelsearch.domain.delegate.BookingDataDelegate
import com.example.tt_hotelsearch.domain.delegate.BookingFinalPriceDelegate
import com.example.tt_hotelsearch.domain.delegate.BookingHotelDelegate
import com.example.tt_hotelsearch.domain.delegate.BookingInformationBuyerDelegate
import com.example.tt_hotelsearch.domain.delegate.BookingInformationTouristDelegate
import com.example.tt_hotelsearch.domain.delegate.ButtonDelegate
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class BookingAdapter(
    interfaceOnClickNext: ButtonDelegate.InterfaceOnClickNext,
    interfaceOnClickAddTourist: BookingAddTouristDelegate.InterfaceOnClickAddTourist,
) : ListDelegationAdapter<List<ListItem>>() {

    init {
        delegatesManager.addDelegate(BookingHotelDelegate())
        delegatesManager.addDelegate(BookingDataDelegate())
        delegatesManager.addDelegate(BookingInformationBuyerDelegate())
        delegatesManager.addDelegate(BookingInformationTouristDelegate())
        delegatesManager.addDelegate(BookingAddTouristDelegate(interfaceOnClickAddTourist))
        delegatesManager.addDelegate(BookingFinalPriceDelegate())
        delegatesManager.addDelegate(ButtonDelegate(interfaceOnClickNext))
    }

    fun updateAdapter(list: List<ListItem>) {
        setItems(list)
    }

    fun addPosition(list: List<ListItem>, position: Int) {
        items = list
        notifyItemInserted(position)
    }
}