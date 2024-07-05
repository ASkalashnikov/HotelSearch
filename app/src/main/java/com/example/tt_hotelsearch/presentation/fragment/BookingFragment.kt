package com.example.tt_hotelsearch.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.tt_hotelsearch.R
import com.example.tt_hotelsearch.databinding.FragmentBookingBinding
import com.example.tt_hotelsearch.domain.adapter.BookingAdapter
import com.example.tt_hotelsearch.domain.delegate.BookingAddTouristDelegate
import com.example.tt_hotelsearch.domain.delegate.ButtonDelegate
import com.example.tt_hotelsearch.presentation.mvvm.BookingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookingFragment : Fragment(), ButtonDelegate.InterfaceOnClickNext, BookingAddTouristDelegate.InterfaceOnClickAddTourist {
    private lateinit var binding: FragmentBookingBinding
    private val mvvm: BookingViewModel by activityViewModels()
    private val bookingAdapter = BookingAdapter(this, this)
    private var addTourist = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentBookingBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mvvm.getBookingList(1)
        initRcView()
        onClickBack()
    }

    private fun initRcView() {
        mvvm.recyclerViewVM.observe(viewLifecycleOwner) {
            if (addTourist == 1) {
                bookingAdapter.updateAdapter(it)
                binding.rcView.adapter = bookingAdapter
            } else {
                bookingAdapter.addPosition(it, 2 + addTourist)
            }
        }
    }

    private fun onClickBack() {
        binding.includeToolbar.imageBack.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, NumberFragment.newInstance())
                .commit()
        }
    }

    override fun onClickAddTourist() {
        // Больше пяти туриста не добавляем
        // (2 + addTourist) На 4-ой позиции появляется вкладка "Второй турист" и тд.
        if (addTourist < 5) {
            addTourist += 1
            mvvm.getBookingList(addTourist)
        }
    }

    override fun onClickNext() {
        mvvm.checkingEditText()

        mvvm.checkingEditTextVM.observe(viewLifecycleOwner) {
            if (it) {
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, PaidFragment.newInstance())
                    .commit()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = BookingFragment()
    }
}