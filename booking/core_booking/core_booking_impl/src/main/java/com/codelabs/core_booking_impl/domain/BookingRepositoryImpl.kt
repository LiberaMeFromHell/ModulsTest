package com.codelabs.core_booking_impl.domain

import com.codelabs.core_booking_api.model.BookingModel
import com.codelabs.core_booking_api.repository.BookingRepository
import javax.inject.Inject

class BookingRepositoryImpl @Inject constructor(): BookingRepository {
    override fun getCredentials(): BookingModel {
        TODO("Not yet implemented")
    }

    override fun setCredentials(credential: BookingModel) {
        TODO("Not yet implemented")
    }
}