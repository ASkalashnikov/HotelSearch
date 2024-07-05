package com.example.tt_hotelsearch.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.tt_hotelsearch.R
import com.example.tt_hotelsearch.databinding.FragmentNumberBinding
import com.example.tt_hotelsearch.domain.adapter.NumberAdapter
import com.example.tt_hotelsearch.domain.delegate.NumberDelegate
import com.example.tt_hotelsearch.presentation.mvvm.NumberViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NumberFragment : Fragment(), NumberDelegate.InterfaceOnClickTakeRoom {
    private lateinit var binding: FragmentNumberBinding
    private val mvvm: NumberViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentNumberBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mvvm.getNumberList()
        initRcView()
        onClickBack()
    }

    private fun initRcView() {
        mvvm.recyclerViewVM.observe(viewLifecycleOwner) {
            binding.rcView.adapter = NumberAdapter(it, this)
        }
    }

    private fun onClickBack() {
        binding.includeToolbar.imageBack.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, HotelFragment.newInstance())
                .commit()
        }
    }

    override fun onClickTakeRoom() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, BookingFragment.newInstance())
            .commit()
    }

    companion object {
        @JvmStatic
        fun newInstance() = NumberFragment()
    }
}