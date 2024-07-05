package com.example.tt_hotelsearch.domain.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tt_hotelsearch.databinding.ItemBookingAddTouristBinding
import com.example.tt_hotelsearch.domain.adapter.ListItem
import com.example.tt_hotelsearch.domain.model.BookingAddTouristModel
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class BookingAddTouristDelegate(private val interfaceOnClickAddTourist: InterfaceOnClickAddTourist) :
    AbsListItemAdapterDelegate<BookingAddTouristModel, ListItem, BookingAddTouristDelegate.AddTouristHolder>() {

    class AddTouristHolder(private val binding: ItemBookingAddTouristBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            model: BookingAddTouristModel,
            interfaceOnClickAddTourist: InterfaceOnClickAddTourist,
        ) = with(binding) {
            textTitle.text = model.title

            imageViewAddTourist.setOnClickListener {
                interfaceOnClickAddTourist.onClickAddTourist()
            }
        }
    }

    override fun isForViewType(
        item: ListItem,
        items: MutableList<ListItem>,
        position: Int,
    ): Boolean {
        return item is BookingAddTouristModel
    }

    override fun onCreateViewHolder(parent: ViewGroup): AddTouristHolder {
        return AddTouristHolder(
            ItemBookingAddTouristBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        item: BookingAddTouristModel,
        holder: AddTouristHolder,
        payloads: MutableList<Any>,
    ) {
        return holder.bind(item, interfaceOnClickAddTourist)
    }

    interface InterfaceOnClickAddTourist {
        fun onClickAddTourist()
    }
}