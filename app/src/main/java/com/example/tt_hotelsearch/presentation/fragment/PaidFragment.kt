package com.example.tt_hotelsearch.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tt_hotelsearch.R
import com.example.tt_hotelsearch.databinding.FragmentPaidBinding
import kotlin.random.Random

class PaidFragment : Fragment() {
    private lateinit var binding: FragmentPaidBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentPaidBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickBack()
        onClickNext()
        orderRandom()
    }

    private fun orderRandom() {
        val cheque =
            "Подтверждение заказа №${100000 + Random.nextInt(90000)} " +
                    "может занять некоторое время (от 1 часа до суток). " +
                    "Как только мы получим ответ от туроператоров, вам на почту придет уведомление."
        binding.textDescription.text = cheque
    }

    private fun onClickBack() {
        binding.includeToolbar.imageBack.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, BookingFragment.newInstance())
                .commit()
        }
    }

    private fun onClickNext() {
        binding.onClickButtonNext.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, HotelFragment.newInstance())
                .commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = PaidFragment()
    }
}