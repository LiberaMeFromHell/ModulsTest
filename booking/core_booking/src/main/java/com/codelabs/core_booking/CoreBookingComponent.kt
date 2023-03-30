package com.codelabs.core_booking

import com.codelabs.core_booking_api.repository.BookingNavigationMediator
import com.codelabs.core_booking_api.repository.BookingRepository
import com.codelabs.core_booking_impl.domain.BookingNavigationMediatorImpl
import com.codelabs.core_booking_impl.domain.BookingRepositoryImpl
import dagger.Binds
import dagger.Component
import dagger.Module

@Module
interface BookingModule {

    @Binds
    fun bindLoginRepository(impl: BookingRepositoryImpl) : BookingRepository

    @Binds
    fun bindBookingNavNavigator(impl: BookingNavigationMediatorImpl) : BookingNavigationMediator
}

@Component(
    modules = [BookingModule::class]
)
interface CoreBookingComponent {

    @Component.Builder
    interface Builder {
        fun build(): CoreBookingComponent
    }

    companion object {

        fun create(): CoreBookingComponent =
            DaggerCoreBookingComponent
                .builder()
                .build()
    }

    fun provideBookingRepository(): BookingRepository

    fun provideBookingNavNavigator(): BookingNavigationMediator
}