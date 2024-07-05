package com.example.tt_hotelsearch.domain.adapter

import com.example.tt_hotelsearch.domain.delegate.HotelBasicInformationDelegate
import com.example.tt_hotelsearch.domain.delegate.ButtonDelegate
import com.example.tt_hotelsearch.domain.delegate.HotelDetailedInformationDelegate
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class HotelAdapter(
    list: List<ListItem>,
    interfaceOnClickAddress: HotelBasicInformationDelegate.InterfaceOnClickAddress,
    interfaceOnClickNext: ButtonDelegate.InterfaceOnClickNext,
) : ListDelegationAdapter<List<ListItem>>() {

    init {
        delegatesManager.addDelegate(HotelBasicInformationDelegate(interfaceOnClickAddress))
        delegatesManager.addDelegate(HotelDetailedInformationDelegate())
        delegatesManager.addDelegate(ButtonDelegate(interfaceOnClickNext))
        setItems(list)
    }
}