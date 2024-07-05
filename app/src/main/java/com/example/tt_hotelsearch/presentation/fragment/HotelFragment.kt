package com.example.tt_hotelsearch.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.tt_hotelsearch.R
import com.example.tt_hotelsearch.databinding.FragmentHotelBinding
import com.example.tt_hotelsearch.domain.adapter.HotelAdapter
import com.example.tt_hotelsearch.domain.delegate.ButtonDelegate
import com.example.tt_hotelsearch.domain.delegate.HotelBasicInformationDelegate
import com.example.tt_hotelsearch.presentation.mvvm.HotelViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HotelFragment : Fragment(), HotelBasicInformationDelegate.InterfaceOnClickAddress,
    ButtonDelegate.InterfaceOnClickNext {
    private lateinit var binding: FragmentHotelBinding
    private val mvvm: HotelViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHotelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mvvm.getHotelList()
        initRcView()
    }

    private fun initRcView() {
        mvvm.recyclerViewVM.observe(viewLifecycleOwner) {
            binding.rcView.adapter = HotelAdapter(it, this, this)
        }
    }

    override fun onClickAddress() {
        Toast.makeText(requireContext(), "Адрес", Toast.LENGTH_SHORT).show()
    }

    override fun onClickNext() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, NumberFragment.newInstance())
            .commit()
    }

    companion object {
        @JvmStatic
        fun newInstance() = HotelFragment()
    }
}