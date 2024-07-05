package com.example.tt_hotelsearch.domain.delegate

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.tt_hotelsearch.R
import com.example.tt_hotelsearch.databinding.ItemBookingInformationTouristBinding
import com.example.tt_hotelsearch.domain.adapter.ListItem
import com.example.tt_hotelsearch.domain.management.AppContext
import com.example.tt_hotelsearch.domain.model.BookingInformationTouristModel
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class BookingInformationTouristDelegate :
    AbsListItemAdapterDelegate<BookingInformationTouristModel, ListItem, BookingInformationTouristDelegate.InformationTouristHolder>() {

    class InformationTouristHolder(private val binding: ItemBookingInformationTouristBinding, contextBinding: Context) :
        RecyclerView.ViewHolder(binding.root) {
            val context = contextBinding

        fun bind(model: BookingInformationTouristModel) = with(binding) {
            textTitle.text = model.title

            AppContext.itemBookingInformationTouristBinding = binding

            cardViewTourist(cardViewName, editTextName, context)
            cardViewTourist(cardViewSurname, editTextSurname, context)
            cardViewTourist(cardViewDateBirth, editTextDateBirth, context)
            cardViewTourist(cardViewCitizenship, editTextCitizenship, context)
            cardViewTourist(cardViewPassportNumber, editTextPassportNumber, context)
            cardViewTourist(cardViewPeriodPassport, editTextPeriodPassport, context)

            // Expandable
            imageViewOpenNested.setOnClickListener {
                if (layoutNested.visibility != View.VISIBLE) {
                    layoutNested.visibility = View.VISIBLE
                    imageViewOpenNested.setImageResource(R.drawable.ic_expand_up)
                } else {
                    layoutNested.visibility = View.GONE
                    imageViewOpenNested.setImageResource(R.drawable.ic_expand_down)
                }
            }
        }

        // Проверяем пустой editText или заполнен и ставим соответствующий setCardBackgroundColor
        private fun cardViewTourist(cardView: CardView, editText: EditText, context: Context) {
            editText.onFocusChangeListener = View.OnFocusChangeListener { view, b ->
                if (b) {
                    cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.constraint_layout))
                    cardView.alpha = 1f
                } else {
                    if (editText.length() < 1) {
                        cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.card_view_error))
                        cardView.alpha = 0.85f
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
        return item is BookingInformationTouristModel
    }

    override fun onCreateViewHolder(parent: ViewGroup): InformationTouristHolder {
        return InformationTouristHolder(
            ItemBookingInformationTouristBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            ), parent.context
        )
    }

    override fun onBindViewHolder(
        item: BookingInformationTouristModel,
        holder: InformationTouristHolder,
        payloads: MutableList<Any>,
    ) {
        return holder.bind(item)
    }
}