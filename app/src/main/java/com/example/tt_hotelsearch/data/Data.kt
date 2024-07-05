package com.example.tt_hotelsearch.data

import com.example.tt_hotelsearch.R
import kotlin.random.Random

object Data {

    // Screen Hotel
    val imageHotelList = listOf(
        R.drawable.hotel_1,
        R.drawable.hotel_2,
        R.drawable.hotel_3
        )

    // Screen Number
    val imageNumberList = listOf(
        R.drawable.number_1,
        R.drawable.number_2,
        R.drawable.number_3,
        R.drawable.number_4,
        R.drawable.number_5,
        R.drawable.number_6,
        R.drawable.number_7,
        R.drawable.number_8,
        R.drawable.number_9
    )

    private val price = 100000 + Random.nextInt(50000)
    val numberPrice = listOf(price,
        price + Random.nextInt(30000),
        price + Random.nextInt(30000)
    )

    // Screen Booking
    val city = listOf("Санкт-Петербург", "Москва", "Волгоград")

    val fuelFees = 7000 + Random.nextInt(2500)
    val serviceFees = 1500 + Random.nextInt(1500)

    val tourist = listOf(
        "Первый",
        "Второй",
        "Третий",
        "Четвёртый",
        "Пятый"
    )
}