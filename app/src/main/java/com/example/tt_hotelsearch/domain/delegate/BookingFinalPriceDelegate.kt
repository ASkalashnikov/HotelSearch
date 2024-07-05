package com.example.tt_hotelsearch.domain.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tt_hotelsearch.databinding.ItemBookingFinalPriceBinding
import com.example.tt_hotelsearch.domain.adapter.ListItem
import com.example.tt_hotelsearch.domain.model.BookingFinalPriceModel
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class BookingFinalPriceDelegate: AbsListItemAdapterDelegate<BookingFinalPriceModel, ListItem, BookingFinalPriceDelegate.FinalPriceHolder>() {

    class FinalPriceHolder(private val binding: ItemBookingFinalPriceBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(model: BookingFinalPriceModel) = with(binding) {
            textTour.text = model.tour
            textFuelFees.text = model.fuelFees
            textServiceFees.text = model.serviceFees
            textTotalPrice.text = model.totalPrice
        }
    }

    override fun isForViewType(
        item: ListItem,
        items: MutableList<ListItem>,
        position: Int,
    ): Boolean {
        return item is BookingFinalPriceModel
    }

    override fun onCreateViewHolder(parent: ViewGroup): FinalPriceHolder {
        return FinalPriceHolder(ItemBookingFinalPriceBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(
        item: BookingFinalPriceModel,
        holder: FinalPriceHolder,
        payloads: MutableList<Any>,
    ) {
        return holder.bind(item)
    }
}