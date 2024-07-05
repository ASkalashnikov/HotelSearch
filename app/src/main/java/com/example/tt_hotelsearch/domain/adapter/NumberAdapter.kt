package com.example.tt_hotelsearch.domain.adapter

import com.example.tt_hotelsearch.domain.delegate.NumberDelegate
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class NumberAdapter(
    list: List<ListItem>,
    interfaceOnClickTakeRoom: NumberDelegate.InterfaceOnClickTakeRoom,
) : ListDelegationAdapter<List<ListItem>>() {

    init {
        delegatesManager.addDelegate(NumberDelegate(interfaceOnClickTakeRoom))
        setItems(list)
    }
}