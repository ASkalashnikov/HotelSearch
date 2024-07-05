package com.example.tt_hotelsearch.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tt_hotelsearch.R
import com.example.tt_hotelsearch.databinding.ActivityMainBinding
import com.example.tt_hotelsearch.presentation.fragment.HotelFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, HotelFragment.newInstance())
            .commit()
    }
}