package com.example.tt_hotelsearch.domain.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tt_hotelsearch.databinding.ItemHotelBasicInformationBinding
import com.example.tt_hotelsearch.domain.adapter.ListItem
import com.example.tt_hotelsearch.domain.model.HotelBasicInformationModel
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class HotelBasicInformationDelegate(private val interfaceOnClickAddress: InterfaceOnClickAddress)
    : AbsListItemAdapterDelegate<HotelBasicInformationModel, ListItem, HotelBasicInformationDelegate.BasicInformationHolder>() {

    class BasicInformationHolder(private val binding: ItemHotelBasicInformationBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(model: HotelBasicInformationModel, interfaceOnClickAddress: InterfaceOnClickAddress)= with(binding) {
            imageSlider.setImageList(model.image)
            textRating.text = model.rating
            textTitle.text = model.title
            textAddress.text = model.address
            textPrice.text = model.price

            textAddress.setOnClickListener {
                interfaceOnClickAddress.onClickAddress()
            }
        }
    }

    override fun isForViewType(
        item: ListItem,
        items: MutableList<ListItem>,
        position: Int,
    ): Boolean {
        return item is HotelBasicInformationModel
    }

    override fun onCreateViewHolder(parent: ViewGroup): BasicInformationHolder {
        return BasicInformationHolder(ItemHotelBasicInformationBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(
        item: HotelBasicInformationModel,
        holder: BasicInformationHolder,
        payloads: MutableList<Any>,
    ) {
        return holder.bind(item, interfaceOnClickAddress)
    }

    interface InterfaceOnClickAddress {
        fun onClickAddress()
    }
}