package com.codelabs.core_booking_impl.domain

import android.content.Context
import android.content.Intent
import com.codelabs.core_booking_api.repository.BookingNavigationMediator
import javax.inject.Inject

class BookingNavigationMediatorImpl @Inject constructor() : BookingNavigationMediator {
    override fun navigateToBookingActivity(context: Context) {
        val clazz = Class.forName("com.codelabs.feature_booking.BookingActivity")
        val intent = Intent().setClass(context, clazz);
        context.startActivity(intent)
    }
}
