package com.example.tt_hotelsearch.domain.delegate

import android.content.Context
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View.OnFocusChangeListener
import android.view.ViewGroup
import android.widget.EditText
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.tt_hotelsearch.R
import com.example.tt_hotelsearch.databinding.ItemBookingInformationBuyerBinding
import com.example.tt_hotelsearch.domain.adapter.ListItem
import com.example.tt_hotelsearch.domain.management.AppContext
import com.example.tt_hotelsearch.domain.model.BookingInformationBuyerModel
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class BookingInformationBuyerDelegate :
    AbsListItemAdapterDelegate<BookingInformationBuyerModel, ListItem, BookingInformationBuyerDelegate.InformationBuyerHolder>() {

    class InformationBuyerHolder(
        private val binding: ItemBookingInformationBuyerBinding, contextBinding: Context) : RecyclerView.ViewHolder(binding.root) {
        val context = contextBinding

        fun bind(model: BookingInformationBuyerModel) = with(binding) {
            textTitle.text = model.title
            textDescription.text = model.description

            AppContext.itemBookingInformationBuyerBinding = binding

            cardViewBuyer(cardViewPhone, editTextPhone, 1, context)
            cardViewBuyer(cardViewEmail, editTextEmail, 2, context)
        }

        // Проверяем пустой editText или заполнен и ставим соответствующий setCardBackgroundColor
        private fun cardViewBuyer(cardView: CardView, editText: EditText, int: Int, context: Context) {
            editText.onFocusChangeListener = OnFocusChangeListener { view, b ->
                if (b) {
                    cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.constraint_layout))
                    cardView.alpha = 1f
                } else {
                    when (int) {
                        1 -> {
                            if (editText.length() < 18) {
                                cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.card_view_error))
                                cardView.alpha = 0.85f
                            }
                        }
                        2 -> {
                            if (!Patterns.EMAIL_ADDRESS.matcher(editText.text.toString()).matches()) {
                                cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.card_view_error))
                                cardView.alpha = 0.85f
                            }
                        }
                    }
                }
            }
        }
    }

    override fun isForViewType(
        item: ListItem,
        items: MutableList<ListItem>,
        position: Int,
    ): Boolean {
        return item is BookingInformationBuyerModel
    }

    override fun onCreateViewHolder(parent: ViewGroup): InformationBuyerHolder {
        return InformationBuyerHolder(
            ItemBookingInformationBuyerBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ), parent.context
        )
    }

    override fun onBindViewHolder(
        item: BookingInformationBuyerModel,
        holder: InformationBuyerHolder,
        payloads: MutableList<Any>,
    ) {
        return holder.bind(item)
    }
}