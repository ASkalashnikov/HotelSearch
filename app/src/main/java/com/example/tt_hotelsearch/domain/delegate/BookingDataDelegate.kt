package com.example.tt_hotelsearch.domain.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tt_hotelsearch.databinding.ItemBookingDataBinding
import com.example.tt_hotelsearch.domain.adapter.ListItem
import com.example.tt_hotelsearch.domain.model.BookingDataModel
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class BookingDataDelegate: AbsListItemAdapterDelegate<BookingDataModel, ListItem, BookingDataDelegate.DataHolder>() {

    class DataHolder(private val binding: ItemBookingDataBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(model: BookingDataModel) = with(binding) {
            textCity.text = model.city
            textCountry.text = model.country
            textCalendar.text = model.calendar
            textNumberNights.text = model.numberNights
            textHotel.text = model.hotel
            textNumber.text = model.number
            textNutrition.text = model.nutrition
        }
    }

    override fun isForViewType(
        item: ListItem,
        items: MutableList<ListItem>,
        position: Int,
    ): Boolean {
        return item is BookingDataModel
    }

    override fun onCreateViewHolder(parent: ViewGroup): DataHolder {
        return DataHolder(ItemBookingDataBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(
        item: BookingDataModel,
        holder: DataHolder,
        payloads: MutableList<Any>,
    ) {
        return holder.bind(item)
    }
}