package com.example.tt_hotelsearch.domain.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tt_hotelsearch.databinding.ItemNumberBinding
import com.example.tt_hotelsearch.domain.adapter.ListItem
import com.example.tt_hotelsearch.domain.management.AppContext
import com.example.tt_hotelsearch.domain.model.NumberModel
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class NumberDelegate(private val interfaceOnClickTakeRoom: InterfaceOnClickTakeRoom) :
    AbsListItemAdapterDelegate<NumberModel, ListItem, NumberDelegate.NumberHolder>() {

    class NumberHolder(private val binding: ItemNumberBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: NumberModel, interfaceOnClickTakeRoom: InterfaceOnClickTakeRoom) =
            with(binding) {
                imageSlider.setImageList(model.image)
                textTitle.text = model.title
                textOne.text = model.textOne
                textTwo.text = model.textTwo
                textPrice.text = model.price

                buttonTakeRoom.setOnClickListener {
                    // Сохраняем позицию
                    AppContext.numberPosition = bindingAdapterPosition
                    interfaceOnClickTakeRoom.onClickTakeRoom()
                }
            }
    }

    override fun isForViewType(
        item: ListItem,
        items: MutableList<ListItem>,
        position: Int,
    ): Boolean {
        return item is NumberModel
    }

    override fun onCreateViewHolder(parent: ViewGroup): NumberHolder {
        return NumberHolder(
            ItemNumberBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        item: NumberModel,
        holder: NumberHolder,
        payloads: MutableList<Any>,
    ) {
        return holder.bind(item, interfaceOnClickTakeRoom)
    }

    interface InterfaceOnClickTakeRoom {
        fun onClickTakeRoom()
    }
}