package com.example.tt_hotelsearch.domain.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tt_hotelsearch.databinding.ItemBookingHotelBinding
import com.example.tt_hotelsearch.domain.adapter.ListItem
import com.example.tt_hotelsearch.domain.model.BookingHotelModel
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class BookingHotelDelegate: AbsListItemAdapterDelegate<BookingHotelModel, ListItem, BookingHotelDelegate.HotelHolder>() {

    class HotelHolder(private val binding: ItemBookingHotelBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(model: BookingHotelModel) = with(binding) {
            textRating.text = model.rating
            textTitle.text = model.title
            textAddress.text = model.address
        }
    }

    override fun isForViewType(
        item: ListItem,
        items: MutableList<ListItem>,
        position: Int,
    ): Boolean {
        return item is BookingHotelModel
    }

    override fun onCreateViewHolder(parent: ViewGroup): HotelHolder {
        return HotelHolder(ItemBookingHotelBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(
        item: BookingHotelModel,
        holder: HotelHolder,
        payloads: MutableList<Any>,
    ) {
        return holder.bind(item)
    }
}