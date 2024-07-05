package com.example.tt_hotelsearch.domain.usecase

import android.content.Context
import android.util.Patterns
import android.widget.EditText
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.tt_hotelsearch.R
import com.example.tt_hotelsearch.domain.management.AppContext
import javax.inject.Inject

class CheckingEditTextBookingUseCase @Inject constructor() {

    // nextScreen записывается один раз если он стал false, чтобы не пустить на следующий экран пользователя
    private var nextScreen = true

    fun execute(context: Context, nextChecking: Boolean): Boolean {

        // Каждый клик кнопки записываем nextScreen = true
        nextScreen = nextChecking

        with(AppContext.itemBookingInformationBuyerBinding) {
            cardViewBuyer(cardViewPhone, editTextPhone, 0, context)
            cardViewBuyer(cardViewEmail, editTextEmail, 1, context)
        }

        with(AppContext.itemBookingInformationTouristBinding) {
            cardViewTourist(cardViewName, editTextName, context)
            cardViewTourist(cardViewSurname, editTextSurname, context)
            cardViewTourist(cardViewDateBirth, editTextDateBirth, context)
            cardViewTourist(cardViewCitizenship, editTextCitizenship, context)
            cardViewTourist(cardViewPassportNumber, editTextPassportNumber, context)
            cardViewTourist(cardViewPeriodPassport, editTextPeriodPassport, context)
        }
        return nextScreen
    }

    // Проверяем пустой editText или заполнен и ставим соответствующий setCardBackgroundColor
    private fun cardViewBuyer(cardView: CardView, editText: EditText, int: Int, context: Context) {

        if (int == 0 && editText.length() == 18) {
            cardView.setCardBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.constraint_layout
                )
            )
            cardView.alpha = 1f
            if (nextScreen) nextScreen = true
        } else if (int == 1 && Patterns.EMAIL_ADDRESS.matcher(editText.text.toString()).matches()) {
            cardView.setCardBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.constraint_layout
                )
            )
            cardView.alpha = 1f
            if (nextScreen) nextScreen = true
        } else {
            cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.card_view_error))
            cardView.alpha = 0.85f
            if (nextScreen) nextScreen = false
        }
    }

    private fun cardViewTourist(cardView: CardView, editText: EditText, context: Context) {

        if (editText.length() > 0) {
            cardView.setCardBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.constraint_layout
                )
            )
            cardView.alpha = 1f
            if (nextScreen) nextScreen = true
        } else {
            cardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.card_view_error))
            cardView.alpha = 0.85f
            if (nextScreen) nextScreen = false
        }
    }
}