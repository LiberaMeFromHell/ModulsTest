package com.codelabs.core_booking_api.repository

import com.codelabs.core_booking_api.model.BookingModel

interface BookingRepository {

    fun getCredentials(): BookingModel

    fun setCredentials(credential: BookingModel)
}
