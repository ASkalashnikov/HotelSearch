package com.example.tt_hotelsearch.domain.usecase

import com.example.tt_hotelsearch.data.Repository
import com.example.tt_hotelsearch.domain.adapter.ListItem
import javax.inject.Inject

class GetNumberListUseCase @Inject constructor(private val repository: Repository) {

    fun execute(): List<ListItem> {
        return repository.requestDataNumber()
    }
}