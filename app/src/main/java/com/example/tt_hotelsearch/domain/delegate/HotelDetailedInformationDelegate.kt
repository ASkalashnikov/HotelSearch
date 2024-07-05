package com.example.tt_hotelsearch.domain.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tt_hotelsearch.databinding.ItemHotelDetailedInformationBinding
import com.example.tt_hotelsearch.domain.adapter.ListItem
import com.example.tt_hotelsearch.domain.model.HotelDetailedInformationModel
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class HotelDetailedInformationDelegate: AbsListItemAdapterDelegate<HotelDetailedInformationModel, ListItem, HotelDetailedInformationDelegate.DetailedInformationHolder>() {

    class DetailedInformationHolder(private val binding: ItemHotelDetailedInformationBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(model: HotelDetailedInformationModel) = with(binding) {
            textOne.text = model.textOne
            textTwo.text = model.textTwo
            textThree.text = model.textThree
            textFour.text = model.textFour
            textDescription.text = model.textDescription
        }
    }

    override fun isForViewType(
        item: ListItem,
        items: MutableList<ListItem>,
        position: Int,
    ): Boolean {
        return item is HotelDetailedInformationModel
    }

    override fun onCreateViewHolder(parent: ViewGroup): DetailedInformationHolder {
        return DetailedInformationHolder(ItemHotelDetailedInformationBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(
        item: HotelDetailedInformationModel,
        holder: DetailedInformationHolder,
        payloads: MutableList<Any>,
    ) {
        return holder.bind(item)
    }
}