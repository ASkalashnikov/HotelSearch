package com.example.tt_hotelsearch.domain.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tt_hotelsearch.databinding.ItemButtonBinding

import com.example.tt_hotelsearch.domain.adapter.ListItem
import com.example.tt_hotelsearch.domain.model.ButtonModel
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class ButtonDelegate(private val interfaceOnClickNext: InterfaceOnClickNext) :
    AbsListItemAdapterDelegate<ButtonModel, ListItem, ButtonDelegate.ButtonHolder>() {

    class ButtonHolder(private val binding: ItemButtonBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            model: ButtonModel,
            interfaceOnClickNext: InterfaceOnClickNext,
        ) = with(binding) {
            onClickButtonNext.text = model.textButton

            onClickButtonNext.setOnClickListener {
                interfaceOnClickNext.onClickNext()
            }
        }
    }

    override fun isForViewType(
        item: ListItem,
        items: MutableList<ListItem>,
        position: Int,
    ): Boolean {
        return item is ButtonModel
    }

    override fun onCreateViewHolder(parent: ViewGroup): ButtonHolder {
        return ButtonHolder(
            ItemButtonBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        item: ButtonModel,
        holder: ButtonHolder,
        payloads: MutableList<Any>,
    ) {
        return holder.bind(item, interfaceOnClickNext)
    }

    interface InterfaceOnClickNext {
        fun onClickNext()
    }
}