package com.example.tt_hotelsearch.data

import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.tt_hotelsearch.domain.adapter.ListItem
import com.example.tt_hotelsearch.domain.management.AppContext
import com.example.tt_hotelsearch.domain.model.BookingAddTouristModel
import com.example.tt_hotelsearch.domain.model.BookingDataModel
import com.example.tt_hotelsearch.domain.model.BookingFinalPriceModel
import com.example.tt_hotelsearch.domain.model.BookingHotelModel
import com.example.tt_hotelsearch.domain.model.BookingInformationBuyerModel
import com.example.tt_hotelsearch.domain.model.BookingInformationTouristModel
import com.example.tt_hotelsearch.domain.model.ButtonModel
import com.example.tt_hotelsearch.domain.model.HotelBasicInformationModel
import com.example.tt_hotelsearch.domain.model.HotelDetailedInformationModel
import com.example.tt_hotelsearch.domain.model.NumberModel
import java.text.NumberFormat
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import javax.inject.Inject
import kotlin.random.Random

class Repository @Inject constructor() {
    private val numberFormat = NumberFormat.getInstance()

    fun requestDataHotel(): List<ListItem> {
        val allItems = ArrayList<ListItem>()

        allItems.add(
            HotelBasicInformationModel(
                image = listOf(
                    SlideModel(Data.imageHotelList[0], ScaleTypes.FIT),
                    SlideModel(Data.imageHotelList[1], ScaleTypes.FIT),
                    SlideModel(Data.imageHotelList[2], ScaleTypes.FIT)
                ),
                rating = "5 Превосходно",
                title = "Steigenberger Makadi",
                address = "Madiat Makadi, Safaga Road, Makadi Bay, Египет",
                price = "${numberFormat.format(Data.numberPrice[0])} ₽"
            )
        )

        allItems.add(
            HotelDetailedInformationModel(
                textOne = "${1 + Random.nextInt(25)}-я линия",
                textTwo = "Платный Wi-Fi",
                textThree = "${10 + Random.nextInt(35)} км до аэропорта",
                textFour = "${150 + Random.nextInt(1500)} м до пляжа",
                textDescription = "Отель VIP-класса с собственными гольф полями." +
                        " Высокий уровень сервиса. " +
                        "Рекомендуем для респектабельного отдыха. " +
                        "Отель принимает гостей от 18 лет!"
            )
        )

        allItems.add(
            ButtonModel(
                textButton = "К выбору номера"
            )
        )
        return allItems
    }

    fun requestDataNumber(): List<ListItem> {
        val allItems = ArrayList<ListItem>()

        allItems.add(
            NumberModel(
                image = listOf(
                    SlideModel(Data.imageNumberList[0], ScaleTypes.FIT),
                    SlideModel(Data.imageNumberList[1], ScaleTypes.FIT),
                    SlideModel(Data.imageNumberList[2], ScaleTypes.FIT)
                ),
                title = "Стандартный с видом на бассейн или сад",
                textOne = "Все включено",
                textTwo = "Кондиционер",
                price = "${numberFormat.format(Data.numberPrice[0])} ₽"
            )
        )

        allItems.add(
            NumberModel(
                image = listOf(
                    SlideModel(Data.imageNumberList[3], ScaleTypes.FIT),
                    SlideModel(Data.imageNumberList[4], ScaleTypes.FIT),
                    SlideModel(Data.imageNumberList[5], ScaleTypes.FIT)
                ),
                title = "Стандартный с видом на бассейн или сад",
                textOne = "Все включено",
                textTwo = "Кондиционер",
                price = "${numberFormat.format(Data.numberPrice[1])} ₽"
            )
        )

        allItems.add(
            NumberModel(
                image = listOf(
                    SlideModel(Data.imageNumberList[6], ScaleTypes.FIT),
                    SlideModel(Data.imageNumberList[7], ScaleTypes.FIT),
                    SlideModel(Data.imageNumberList[8], ScaleTypes.FIT)
                ),
                title = "Стандартный с видом на бассейн или сад",
                textOne = "Все включено",
                textTwo = "Кондиционер",
                price = "${numberFormat.format(Data.numberPrice[2])} ₽"
            )
        )
        return allItems
    }

    fun requestDataBooking(addTourist: Int): List<ListItem> {
        val allItems = ArrayList<ListItem>()

        allItems.add(
            BookingHotelModel(
                rating = "5 Превосходно",
                title = "Steigenberger Makadi",
                address = "Madiat Makadi, Safaga Road, Makadi Bay, Египет"
            )
        )

        allItems.add(
            BookingDataModel(
                city = Data.city[Random.nextInt(2)],
                country = "Египет, Хургада",
                calendar = "${calendar(System.currentTimeMillis())} - ${calendar(System.currentTimeMillis() + 604800000)}",
                numberNights = "7 ночей",
                hotel = "Steigenberger Makadi",
                number = "Стандартный с видом на бассейн или сад",
                nutrition = "Все включено"
            )
        )

        allItems.add(
            BookingInformationBuyerModel(
                title = "Информация о покупателе",
                description = "Эти данные никому не передаются. После оплаты мы вышлим чек на указанный вами номер и почту"
            )
        )

        for (i in 0 until addTourist) {
            allItems.add(
                BookingInformationTouristModel(
                    title = "${Data.tourist[i]} турист"
                )
            )
        }

        allItems.add(
            BookingAddTouristModel(
                title = "Добавить туриста"
            )
        )

        allItems.add(
            BookingFinalPriceModel(
                tour = "${numberFormat.format(Data.numberPrice[AppContext.numberPosition])} ₽",
                fuelFees = numberFormat.format(Data.fuelFees).toString(),
                serviceFees = numberFormat.format(Data.serviceFees).toString(),
                totalPrice = "${numberFormat.format(Data.numberPrice[AppContext.numberPosition] + Data.fuelFees + Data.serviceFees)} ₽"
            )
        )

        allItems.add(
            ButtonModel(
                textButton = "Оплатить ${numberFormat.format(Data.numberPrice[AppContext.numberPosition] + Data.fuelFees + Data.serviceFees)} ₽"
            )
        )
        return allItems
    }

    private fun calendar(systemTime: Long): String {
        val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        val instant = Instant.ofEpochMilli(systemTime)
        val date = LocalDateTime.ofInstant(instant, ZoneId.of("UTC"))
        return formatter.format(date)
    }
}