package com.codelabs.feature_booking.di

import com.codelabs.core_booking.CoreBookingComponent
import com.codelabs.feature_booking.BookingActivity
import com.codelabs.feature_booking.BookingActivity2
import com.codelabs.feature_booking.BookingActivity3
import dagger.Component

@Component(
    dependencies = [CoreBookingComponent::class]
)
interface BookingComponent {

    fun inject(activity: BookingActivity)

    fun inject(activity: BookingActivity2)

    fun inject(activity: BookingActivity3)

    @Component.Builder
    interface Builder {
        fun coreBookingComponent(component: CoreBookingComponent): Builder
        fun create(): BookingComponent
    }

    companion object {
        fun create(): BookingComponent =
            DaggerBookingComponent
                .builder()
                .coreBookingComponent(CoreBookingComponent.create())
                .create()
    }
}